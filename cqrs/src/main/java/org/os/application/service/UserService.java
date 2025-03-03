package org.os.application.service;

import org.os.application.dto.UserDto;
import org.os.domain.entity.User;

import java.util.Optional;
import java.util.UUID;

public interface UserService {
    Optional<User> getUser(UUID id);
    Optional<User> updateUser(UUID id, UserDto userDto);
    Optional<User> deleteUser(UUID id);
    Optional<User> createUser(UserDto userDto);
    Optional<User> createUserWithAddress(User user);
}
