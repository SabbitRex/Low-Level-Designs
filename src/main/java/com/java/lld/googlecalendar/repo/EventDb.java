package com.java.lld.googlecalendar.repo;

import com.java.lld.googlecalendar.entity.Event;

import java.util.List;

public interface EventDb {

    void createEvent(String userid, Event event);
    Event getEvent(String calendarId, String eventId);
    void deleteEvent(String userId, String eventId);
    Event updateEvent(String userId, Event event);
    List<Event> getAllEvents(String userId);
}
