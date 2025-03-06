package com.java.lld.googlecalendar.repo.impl;

import com.java.lld.googlecalendar.entity.Calendar;
import com.java.lld.googlecalendar.entity.Event;
import com.java.lld.googlecalendar.entity.User;
import com.java.lld.googlecalendar.repo.CalendarDb;
import com.java.lld.googlecalendar.repo.EventDb;
import com.java.lld.googlecalendar.repo.UserDb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Builder
@Getter
@Setter
public class EventDbImpl implements EventDb {

    private UserDb userDb;
    private CalendarDb calendarDb;
    private final Map<String, Event> eventDb = new HashMap<>();

    @Override
    public void createEvent(String userId, Event event) {

        User user = this.userDb.getUser(userId);
        Calendar calendar = this.calendarDb.getCalendar(user.getCalendarId());
        List<Event> events = calendar.getEvents();
        events.add(event);
        calendar.setEvents(events);
        this.calendarDb.updateCalendar(calendar);
        this.eventDb.put(event.getEventId(), event);
    }

    @Override
    public Event getEvent(String calendarId, String eventId) {
        return this.eventDb.get(eventId);
    }

    @Override
    public void deleteEvent(String userId, String eventId) {

        User user = this.userDb.getUser(userId);
        Calendar calendar = this.calendarDb.getCalendar(user.getCalendarId());
        List<Event> events = calendar.getEvents();

        Event eventToDelete = null;
        for (Event event : events) {
            if (event.getEventId().equals(eventId)) {
                eventToDelete = event;
                break;
            }
        }
        events.remove(eventToDelete);
        calendar.setEvents(events);
        this.calendarDb.updateCalendar(calendar);
        this.eventDb.remove(eventId);
    }

    @Override
    public Event updateEvent(String userId, Event event) {

        User user = this.userDb.getUser(userId);
        Calendar calendar = this.calendarDb.getCalendar(user.getCalendarId());
        List<Event> events = calendar.getEvents();

        Event eventToRemove = null;

        for (Event currentEvent : events) {
            if (currentEvent.getEventId().equals(event.getEventId())) {
                eventToRemove = currentEvent;
                break;
            }
        }

        events.remove(eventToRemove);
        events.add(event);
        calendar.setEvents(events);
        this.calendarDb.updateCalendar(calendar);
        return this.eventDb.put(event.getEventId(), event);
    }

    @Override
    public List<Event> getAllEvents(String userId) {

        User user = this.userDb.getUser(userId);
        String calendarId = user.getCalendarId();
        Calendar calendar = this.calendarDb.getCalendar(calendarId);
        return calendar.getEvents();
    }
}
