package com.java.lld.googlecalendar.controller;

import com.java.lld.googlecalendar.entity.Calendar;
import com.java.lld.googlecalendar.entity.Event;
import com.java.lld.googlecalendar.entity.User;
import com.java.lld.googlecalendar.repo.CalendarDb;
import com.java.lld.googlecalendar.repo.EventDb;
import com.java.lld.googlecalendar.repo.UserDb;
import com.java.lld.googlecalendar.repo.impl.CalendarDbImpl;
import com.java.lld.googlecalendar.repo.impl.EventDbImpl;
import com.java.lld.googlecalendar.repo.impl.UserDbImpl;
import com.java.lld.googlecalendar.service.CalendarMgmtService;
import com.java.lld.googlecalendar.service.UserMgmtService;
import com.java.lld.googlecalendar.service.impl.CalendarMgmtServiceImpl;
import com.java.lld.googlecalendar.service.impl.UserMgmtServiceImpl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {

        // DB Init
        UserDb userDb = UserDbImpl.builder().build();
        CalendarDb calendarDb = CalendarDbImpl.builder().userDb(userDb).build();
        EventDb eventDb = EventDbImpl.builder().calendarDb(calendarDb).userDb(userDb).build();

        // Service Init
        CalendarMgmtService calService = CalendarMgmtServiceImpl.builder().eventDb(eventDb).build();

        UserMgmtService userService = UserMgmtServiceImpl.builder().userDb(userDb).calendarDb(calendarDb).build();

        // Create User
        User u1 = User.builder().userId("1").userName("sharad").emailId("s@s.com").build();
        User u2 = User.builder().userId("2").userName("anurag").emailId("a@a.com").build();
        User u3 = User.builder().userId("3").userName("rohit").emailId("r@r.com").build();

        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);

        // Create Event
        Event e1 = Event.builder().userId("1").eventId("11_event")
                .title("User1 Event").eventDateTime(LocalDateTime.now()).description("Desc User 1").location("Pune").invites(new HashMap<>()).build();

        Event e2 = Event.builder().userId("2").eventId("21_event")
                .title("User2 Event").eventDateTime(LocalDateTime.now()).description("Desc User 2").location("Ggn").invites(new HashMap<>()).build();

        Event e3 = Event.builder().userId("3").eventId("31_event")
                .title("User3 Event").eventDateTime(LocalDateTime.now()).description("Desc User 3").location("Bombay").invites(new HashMap<>()).build();

        Event e4 = Event.builder().userId("1").eventId("12_event")
                .title("User1 Event").eventDateTime(LocalDateTime.now()).description("Desc User 1").location("Pune").invites(new HashMap<>()).build();


        calService.createEvent("1", e1);
        calService.createEvent("2", e2);
        calService.createEvent("3", e3);
        calService.createEvent("1", e4);

        calService.getAllEvents("1");

        e4.setLocation("Blr");
        calService.updateEvent("1", e4);

        Map<String, Boolean> inviteeMap = new HashMap<>();
        inviteeMap.put("a@a.com", false);
        calService.inviteParticipant(u1.getUserId(), String.format("%s_%s", u1.getUserId(), u1.getUserName()), "12_event", inviteeMap);

        System.out.println("Finish!");

    }
}
