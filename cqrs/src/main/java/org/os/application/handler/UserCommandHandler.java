package org.os.application.handler;

import org.os.application.command.AddAddressToUserCommand;
import org.os.application.command.CreateUserCommand;
import org.os.application.command.DeleteUserCommand;
import org.os.application.command.UpdateUserCommand;
import org.os.application.dto.UserDto;
import org.os.domain.entity.Address;
import org.os.domain.entity.User;
import org.os.domain.event.AddressAddedToUserEvent;
import org.os.domain.event.UserCreatedEvent;
import org.os.domain.event.UserDeletedEvent;
import org.os.domain.event.UserUpdatedEvent;
import org.os.domain.repository.UserRepository;
import org.os.infrastructure.event.EventBus;

import java.util.UUID;

public class UserCommandHandler {
    private final UserRepository userRepository;
    private final EventBus eventBus;
    public UserCommandHandler(UserRepository userRepository, EventBus eventBus) {
        this.userRepository = userRepository;
        this.eventBus = eventBus;
    }

    public void handle(CreateUserCommand command) {
        UserDto dto = new UserDto(command.fullName());
        var user = userRepository.createUser(dto);
        eventBus.publish(new UserCreatedEvent(user.get().getId(), user.get().getFullName()));
    }

    public void handle(UpdateUserCommand command) {
        UserDto dto = new UserDto(command.fullName());
        var user = userRepository.updateUser(command.id(),dto);
        eventBus.publish(new UserUpdatedEvent(user.get().getId(), user.get().getFullName()));
    }

    public void handle(DeleteUserCommand command) {
        userRepository.deleteUser(command.id());
        eventBus.publish(new UserDeletedEvent(command.id()));
    }

    public void handle(AddAddressToUserCommand command) {
        User user = userRepository.getUser(command.userId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        user.getAddresses().add(new Address(UUID.randomUUID(), command.addressName()));
        userRepository.createUserWithAddress(user);
        eventBus.publish(new AddressAddedToUserEvent(user.getId(), command.addressName()));

    }
}

