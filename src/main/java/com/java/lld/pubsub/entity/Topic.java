package com.java.lld.pubsub.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Topic {

    private String topicId;
    private String topicName;
    private List<Message> messages;
}
