package com.isa.eshop.users;


import at.favre.lib.crypto.bcrypt.BCrypt;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Optional;
import java.util.UUID;

@SessionScoped
public class LoggedUserService implements Serializable {

    @Inject
    private UserService userService;

    private User loggedUser;

    public Optional<User> getLoggedUser() {
        return Optional.ofNullable(loggedUser);
    }

    public boolean logUser(String email, String password) {
//        final Optional<User> maybeUser = userService.findByEmail(email);
        final String maybeUser = userService.findByEmail(email);
//        final Optional<User> maybeLoggedUser = maybeUser.map(user -> {
//            if (isPasswordMatched(password, user)) {
//                return user;
//            }
//            return null;
//        });
//        maybeLoggedUser.ifPresent(user -> loggedUser = user);
//        return maybeLoggedUser.isPresent();
        loggedUser = User.builder().id(UUID.randomUUID()).email("test@test.pl").password("123").build();
        return true;
    }

    private boolean isPasswordMatched(String password, User user) {
        return BCrypt.verifyer().verify(password.toCharArray(),
                user.getPassword()).verified;
    }
}
