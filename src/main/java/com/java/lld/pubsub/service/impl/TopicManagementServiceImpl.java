package com.java.lld.pubsub.service.impl;

import com.java.lld.pubsub.entity.Topic;
import com.java.lld.pubsub.repo.TopicDb;
import com.java.lld.pubsub.service.TopicManagementService;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TopicManagementServiceImpl implements TopicManagementService {

    private final TopicDb topicDb;

    @Override
    public Topic createTopic(String topicName) {
        return this.topicDb.createTopic(topicName);
    }

    @Override
    public void deleteTopic(String topicId) {
        this.topicDb.deleteTopic(topicId);
    }
}
