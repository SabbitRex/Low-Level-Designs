package com.java.lld.pubsub.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Message {
    private String content;
}
