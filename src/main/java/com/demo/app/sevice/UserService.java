package com.demo.app.sevice;

import com.demo.app.model.User;

public interface UserService {
    boolean exists(String username);
    User create(User user);
    void remove(User user);
}
