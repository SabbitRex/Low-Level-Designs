package com.java.lld.pubsub.repo;

import com.java.lld.pubsub.entity.Topic;

public interface TopicDb {

    Topic createTopic(String topicName);
    void deleteTopic(String topicName);
    Topic getTopic(String topicName);
    void persist(Topic topic);
}
