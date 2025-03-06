package com.java.lld.googlecalendar.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@Builder
@Setter
@Getter
public class Event {

    private String userId;
    private String eventId;
    private String title;
    private String description;
    private String location;
    private LocalDateTime eventDateTime;
    private Map<String, Boolean> invites;
}
