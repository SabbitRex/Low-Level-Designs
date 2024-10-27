package com.java.lld.pubsub.service.impl;

import com.java.lld.pubsub.entity.Message;
import com.java.lld.pubsub.entity.Topic;
import com.java.lld.pubsub.repo.TopicDb;
import com.java.lld.pubsub.service.Subscriber;
import lombok.Builder;

import java.util.List;

@Builder
public class SubscriberServiceImpl implements Subscriber {

    private final TopicDb topicDb;

    @Override
    public String ingestMessage(String topicName) {

        Topic topic = this.topicDb.getTopic(topicName);

        if (topic != null) {

            List<Message> messages = topic.getMessages();

            Message message = messages.stream().findFirst().orElse(null);
            messages.remove(message);

            if (message != null && message.getContent() != null) {
                return message.getContent();
            }
        }

        return null;
    }
}