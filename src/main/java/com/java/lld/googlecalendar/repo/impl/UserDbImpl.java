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
import java.util.UUID;

@Getter
@Setter
@Builder
public class UserDbImpl implements UserDb {

    private CalendarDb calendarDb;
    private final Map<String, User> userDb = new HashMap<>();

    @Override
    public void createUser(User user) {
        this.userDb.put(user.getUserId(), user);
    }

    @Override
    public User getUser(String userId) {
        return this.userDb.get(userId);
    }

    @Override
    public Calendar getUserCalendar(String userId) {

        User user = this.userDb.get(userId);
        String calendarId = user.getCalendarId();
        return this.calendarDb.getCalendar(calendarId);
    }

    @Override
    public void updateUser(User user) {
        this.userDb.put(user.getUserId(), user);
    }
}
