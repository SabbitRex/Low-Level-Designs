package com.java.lld.pubsub.service;

public interface Subscriber {
    String ingestMessage(String topicName);
}