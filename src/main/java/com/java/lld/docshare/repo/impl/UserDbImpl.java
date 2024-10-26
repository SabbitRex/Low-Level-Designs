package com.java.lld.docshare.repo.impl;

import com.java.lld.docshare.entity.User;
import com.java.lld.docshare.repo.UserDb;
import lombok.Builder;

import java.util.HashMap;
import java.util.Map;

@Builder
public class UserDbImpl implements UserDb {

    private final Map<String, User> userDbMap = new HashMap<>();

    @Override
    public User createUser(User user) {

        String userName = user.getUserName();

        if (!userDbMap.containsKey(userName)) {
            this.userDbMap.put(userName, user);
            System.out.println("User created!");

        } else {
            System.out.println("User already present!");
        }

        return user;
    }
}
