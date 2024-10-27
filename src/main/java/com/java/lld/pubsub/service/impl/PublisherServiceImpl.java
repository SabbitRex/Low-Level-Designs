package com.java.lld.pubsub.service.impl;

import com.java.lld.pubsub.entity.Message;
import com.java.lld.pubsub.entity.Topic;
import com.java.lld.pubsub.repo.TopicDb;
import com.java.lld.pubsub.service.Publisher;
import lombok.Builder;

import java.util.List;

@Builder
public class PublisherServiceImpl implements Publisher {

    private final TopicDb topicDb;

    @Override
    public void publishMessage(String topicName, String message) {

        Topic topic = this.topicDb.getTopic(topicName);

        if (topic != null) {

            List<Message> messages = topic.getMessages();
            messages.add(Message.builder().content(message).build());
            topic.setMessages(messages);
            topicDb.persist(topic);
        } else {

            System.out.println("Topic does not exist.");
        }
    }
}