package com.demo.app.model;

import lombok.Data;

import java.util.UUID;

@Data
public class User {
    private UUID id = UUID.randomUUID();
    private String username;
    private String password;
    private String fullName;
    private boolean superuser;
}
