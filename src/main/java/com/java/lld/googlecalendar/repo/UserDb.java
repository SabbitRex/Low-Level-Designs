package com.java.lld.googlecalendar.repo;

import com.java.lld.googlecalendar.entity.Calendar;
import com.java.lld.googlecalendar.entity.User;

public interface UserDb {

    void createUser(User user);
    User getUser(String userId);
    Calendar getUserCalendar(String userId);
    void updateUser(User user);
}
