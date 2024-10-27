package com.java.lld.pubsub.service;

public interface Publisher {

    void publishMessage(String topicName, String message);
}