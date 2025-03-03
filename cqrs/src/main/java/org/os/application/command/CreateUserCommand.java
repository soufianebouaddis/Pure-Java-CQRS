package org.os.application.command;


public record CreateUserCommand(String fullName) implements UserCommand {}

