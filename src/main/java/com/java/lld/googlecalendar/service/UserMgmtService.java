package com.java.lld.googlecalendar.service;

import com.java.lld.googlecalendar.entity.Calendar;
import com.java.lld.googlecalendar.entity.User;

public interface UserMgmtService {

    void createUser(User user);
    User getUser(String userId);
    Calendar getUserCalendar(String userId);
}