package com.java.lld.docshare.service.impl;

import com.java.lld.docshare.entity.User;
import com.java.lld.docshare.repo.UserDb;
import com.java.lld.docshare.service.UserManagementService;
import lombok.Builder;

@Builder
public class UserManagementServiceImpl implements UserManagementService {

    private final UserDb userDb;

    @Override
    public User createUser(User user) {
        return this.userDb.createUser(user);
    }
}