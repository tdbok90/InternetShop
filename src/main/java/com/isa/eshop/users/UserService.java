package com.isa.eshop.users;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.NoArgsConstructor;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Singleton
@NoArgsConstructor
public class UserService implements Serializable {

    @Inject
//    private UserDAO userDAO;

    public List<User> findAllUsers() {
        List<User> users = new ArrayList<>();
        users.add(User.builder()
                .id(UUID.randomUUID())
                .email("abc@example.org")
                .password(BCrypt.withDefaults()
                        .hashToString(12, "hasz".toCharArray()))
                .build());
        return users;
    }

//    public Optional<User> findByEmail(String email) {
//        return userDAO.findByEmail(email);
//    }

    public String findByEmail(String email) {
        return "test@test.pl";
    }
}
