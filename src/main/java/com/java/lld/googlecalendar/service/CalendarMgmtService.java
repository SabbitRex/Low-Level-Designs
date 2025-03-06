package com.java.lld.googlecalendar.service;

import com.java.lld.googlecalendar.entity.Event;

import java.util.List;
import java.util.Map;

public interface CalendarMgmtService {

    void createEvent(String userid, Event event);
    List<Event> getAllEvents(String userId);
    Event getEvent(String calendarId, String eventId);
    void deleteEvent(String userId, String eventId);
    Event updateEvent(String userId, Event event);
    void inviteParticipant(String userId, String calendarId, String eventId, Map<String, Boolean> invites);
}
