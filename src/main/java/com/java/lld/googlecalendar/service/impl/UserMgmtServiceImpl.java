package com.java.lld.googlecalendar.service.impl;

import com.java.lld.googlecalendar.entity.Calendar;
import com.java.lld.googlecalendar.entity.User;
import com.java.lld.googlecalendar.repo.CalendarDb;
import com.java.lld.googlecalendar.repo.UserDb;
import com.java.lld.googlecalendar.service.UserMgmtService;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserMgmtServiceImpl implements UserMgmtService {

    private CalendarDb calendarDb;
    private UserDb userDb;

    @Override
    public void createUser(User user) {
        String calendarId = String.format("%s_%s", user.getUserId(), user.getUserName());
        this.userDb.createUser(user);
        this.calendarDb.createCalendarForUser(user.getUserId(), calendarId);
    }

    @Override
    public User getUser(String userId) {
        return this.userDb.getUser(userId);
    }

    @Override
    public Calendar getUserCalendar(String userId) {
        return this.userDb.getUserCalendar(userId);
    }
}