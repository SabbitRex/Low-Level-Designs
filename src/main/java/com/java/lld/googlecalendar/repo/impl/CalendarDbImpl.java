package com.java.lld.googlecalendar.repo.impl;

import com.java.lld.googlecalendar.entity.Calendar;
import com.java.lld.googlecalendar.entity.User;
import com.java.lld.googlecalendar.repo.CalendarDb;
import com.java.lld.googlecalendar.repo.UserDb;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Builder
@Getter
@Setter
public class CalendarDbImpl implements CalendarDb {

    private UserDb userDb;
    private final Map<String, Calendar> calendarDb = new HashMap<>();


    @Override
    public void createCalendarForUser(String userId, String calendarId) {
        User user = this.userDb.getUser(userId);
        user.setCalendarId(calendarId);
        this.userDb.updateUser(user);
        Calendar calendar = Calendar.builder().userId(userId).calendarId(calendarId).events(new ArrayList<>()).build();
        this.calendarDb.put(calendarId, calendar);
    }

    @Override
    public Calendar getCalendar(String calendarId) {
        return this.calendarDb.get(calendarId);
    }

    @Override
    public void updateCalendar(Calendar calendar) {
        this.calendarDb.put(calendar.getCalendarId(), calendar);
    }
}