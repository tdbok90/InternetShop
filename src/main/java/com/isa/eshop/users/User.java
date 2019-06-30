package com.isa.eshop.users;

import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
public class User {

    private UUID id;
    private String login;
    private String email;
    private String password;
    private Role role;
}

