package com.java.lld.googlecalendar.repo;

import com.java.lld.googlecalendar.entity.Calendar;

public interface CalendarDb {

    void createCalendarForUser(String userId, String calendarId);
    Calendar getCalendar(String calendarId);
    void updateCalendar(Calendar calendar);

}
