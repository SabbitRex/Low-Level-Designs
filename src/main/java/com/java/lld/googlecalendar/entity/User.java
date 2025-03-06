package com.java.lld.googlecalendar.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class User {

    private String userId;
    private String userName;
    private String emailId;
    private String calendarId;
}
