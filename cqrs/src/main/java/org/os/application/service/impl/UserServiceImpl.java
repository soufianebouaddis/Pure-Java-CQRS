package org.os.application.service.impl;

import org.os.application.dto.UserDto;
import org.os.application.service.UserService;
import org.os.domain.entity.User;
import org.os.domain.repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> getUser(UUID id) {
        return userRepository.getUser(id);
    }

    @Override
    public Optional<User> updateUser(UUID id, UserDto userDto) {
        return userRepository.updateUser(id,userDto);
    }

    @Override
    public Optional<User> deleteUser(UUID id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public Optional<User> createUser(UserDto userDto) {
        return userRepository.createUser(userDto);
    }

    @Override
    public Optional<User> createUserWithAddress(User user) {
        return userRepository.createUserWithAddress(user);
    }
}
