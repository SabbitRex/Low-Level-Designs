package com.java.lld.pubsub;

import com.java.lld.pubsub.entity.Topic;
import com.java.lld.pubsub.repo.TopicDb;
import com.java.lld.pubsub.repo.impl.TopicDbImpl;
import com.java.lld.pubsub.service.Publisher;
import com.java.lld.pubsub.service.Subscriber;
import com.java.lld.pubsub.service.TopicManagementService;
import com.java.lld.pubsub.service.impl.PublisherServiceImpl;
import com.java.lld.pubsub.service.impl.SubscriberServiceImpl;
import com.java.lld.pubsub.service.impl.TopicManagementServiceImpl;

public class TestPubSub {

    /*
    We have to design a message queue supporting publisher-subscriber model. It should support following operations:

    1. It should support multiple topics where messages can be published.
    2. Publisher should be able to publish a message to a particular topic.
    3. Subscribers should be able to subscribe to a topic.
    4. Whenever a message is published to a topic, all the subscribers, who are subscribed to that topic, should receive the message.
    5. Subscribers should be able to run in parallel
    */
    public static void main(String[] args) {

        TopicDb topicDb = TopicDbImpl.builder().build();
        TopicManagementService topicManagementService = TopicManagementServiceImpl.builder().topicDb(topicDb).build();

        Topic t1 = topicManagementService.createTopic("t1");
        Topic t2 = topicManagementService.createTopic("t2");

        Publisher p1 = PublisherServiceImpl.builder().topicDb(topicDb).build();
        p1.publishMessage("t1", "Hello from publisher p1 message 1");
        p1.publishMessage("t3", "Hello from publisher p1 message 2");
        p1.publishMessage("t2", "Hello from publisher p1 message 3");

        Publisher p2 = PublisherServiceImpl.builder().topicDb(topicDb).build();
        p2.publishMessage("t1", "Hello from publisher p2 message 1");

        Subscriber s1 = SubscriberServiceImpl.builder().topicDb(topicDb).build();
        System.out.println(s1.ingestMessage("t1"));
        System.out.println(s1.ingestMessage("t1"));
        System.out.println(s1.ingestMessage("t2"));
    }
}
