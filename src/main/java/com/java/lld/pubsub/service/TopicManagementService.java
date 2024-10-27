package com.java.lld.pubsub.service;

import com.java.lld.pubsub.entity.Topic;

public interface TopicManagementService {

    Topic createTopic(String topicName);
    void deleteTopic(String topicId);
}