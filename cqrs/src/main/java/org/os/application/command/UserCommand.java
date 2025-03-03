package org.os.application.command;

public sealed
        interface
            UserCommand
        permits
            CreateUserCommand,
            UpdateUserCommand,
            DeleteUserCommand,
            AddAddressToUserCommand {}

