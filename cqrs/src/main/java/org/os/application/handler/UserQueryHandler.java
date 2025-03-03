package org.os.application.handler;

import org.os.application.query.GetUserQuery;
import org.os.domain.entity.User;
import org.os.domain.repository.UserRepository;

import java.util.Optional;

public class UserQueryHandler {
    private final UserRepository userRepository;

    public UserQueryHandler(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> handle(GetUserQuery query) {
        return userRepository.getUser(query.id());
    }
}

