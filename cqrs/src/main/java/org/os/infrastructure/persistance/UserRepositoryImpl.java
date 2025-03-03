package org.os.infrastructure.persistance;

import org.os.application.dto.UserDto;
import org.os.domain.entity.Address;
import org.os.domain.entity.User;
import org.os.domain.repository.UserRepository;
import org.os.infrastructure.exception.UserNotFound;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserRepositoryImpl implements UserRepository {
    private Map<String,User> store = new HashMap<>();
    @Override
    public Optional<User> getUser(UUID id) {
        Optional<User> user = Optional.ofNullable(store.get(id.toString()));
        if(user.isPresent()) return user;
        else throw new UserNotFound("User not found with id => "+id);
    }

    @Override
    public Optional<User> updateUser(UUID id, UserDto userDto) {
        Optional<User> user = Optional.ofNullable(store.get(id.toString()));
        if(user.isPresent()) {
            user.get().setFullName(userDto.fullName());
            store.put(id.toString(),user.get());
            return user;
        }
        else throw new UserNotFound("User not found with id => "+id);
    }

    @Override
    public Optional<User> deleteUser(UUID id) {
        Optional<User> user = Optional.ofNullable(store.get(id.toString()));
        if(user.isPresent()) {
            var temp = user;
            store.remove(id.toString(),user);
            return temp;
        }
        else throw new UserNotFound("User not found with id => "+id);
    }

    @Override
    public Optional<User> createUser(UserDto userDto) {
        User newUser = new User(UUID.randomUUID(), userDto.fullName());
        store.put(newUser.getId().toString(),newUser);
        return Optional.of(newUser);
    }

    @Override
    public Optional<User> createUserWithAddress(User user) {
        User newUser= new User(UUID.randomUUID(),user.getFullName());
        store.put(newUser.getId().toString(),newUser);
        return Optional.of(newUser);
    }
}
