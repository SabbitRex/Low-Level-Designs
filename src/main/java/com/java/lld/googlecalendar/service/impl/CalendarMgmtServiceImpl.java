package com.java.lld.googlecalendar.service.impl;

import com.java.lld.googlecalendar.entity.Event;
import com.java.lld.googlecalendar.entity.User;
import com.java.lld.googlecalendar.repo.EventDb;
import com.java.lld.googlecalendar.service.CalendarMgmtService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@Builder
@Setter
@Getter
public class CalendarMgmtServiceImpl implements CalendarMgmtService {

    private EventDb eventDb;

    @Override
    public void createEvent(String userid, Event event) {
        this.eventDb.createEvent(userid, event);
    }

    @Override
    public List<Event> getAllEvents(String userId) {
        return this.eventDb.getAllEvents(userId);
    }

    @Override
    public Event getEvent(String calendarId, String eventId) {
        return this.eventDb.getEvent(calendarId, eventId);
    }

    @Override
    public void deleteEvent(String userId, String eventId) {
        this.eventDb.deleteEvent(userId, eventId);
    }

    @Override
    public Event updateEvent(String userId, Event event) {
        return this.eventDb.updateEvent(userId, event);
    }

    @Override
    public void inviteParticipant(String userId, String calendarId, String eventId, Map<String, Boolean> invites) {
        Event event = this.eventDb.getEvent(calendarId, eventId);
        event.setInvites(invites);
        this.eventDb.updateEvent(userId, event);
    }
}