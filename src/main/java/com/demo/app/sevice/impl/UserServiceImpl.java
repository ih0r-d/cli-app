package com.demo.app.sevice.impl;

import com.demo.app.model.User;
import com.demo.app.sevice.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

@Service
public class UserServiceImpl implements UserService {
    private final static List<User> USERS = new CopyOnWriteArrayList<>();
    private final static String ADMIN = "admin";

    @Override
    public boolean exists(String username) {
        return username.equalsIgnoreCase(ADMIN);
    }

    @Override
    public User create(User user) {
        USERS.add(user);
        return user;
    }

    @Override
    public void remove(User user) {
        USERS.removeIf(u -> Objects.equals(user.getId(), u));
    }
}
