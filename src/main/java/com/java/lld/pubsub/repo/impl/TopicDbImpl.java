package com.java.lld.pubsub.repo.impl;

import com.java.lld.pubsub.entity.Topic;
import com.java.lld.pubsub.repo.TopicDb;
import lombok.Builder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Builder
public class TopicDbImpl implements TopicDb {

    private final Map<String, Topic> topicDbMap = new HashMap<>();

    @Override
    public Topic createTopic(String topicName) {

        if (!this.topicDbMap.containsKey(topicName)) {

            String topicId = String.valueOf(UUID.randomUUID());
            Topic topic = Topic.builder().topicId(topicId).topicName(topicName).messages(new ArrayList<>()).build();
            return this.topicDbMap.put(topicName, topic);

        } else {
            System.out.println("Topic already present!");
            return null;
        }
    }

    @Override
    public void deleteTopic(String topicName) {
        this.topicDbMap.remove(topicName);
    }

    @Override
    public Topic getTopic(String topicName) {
        return this.topicDbMap.get(topicName);
    }

    @Override
    public void persist(Topic topic) {
        this.topicDbMap.put(topic.getTopicName(), topic);
    }
}
