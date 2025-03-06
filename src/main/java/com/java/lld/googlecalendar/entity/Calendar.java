package com.java.lld.googlecalendar.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class Calendar {

    private String calendarId;
    private String userId;
    List<Event> events;
}
