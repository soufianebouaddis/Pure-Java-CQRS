package org.os.application.command;

import java.util.UUID;

public record DeleteUserCommand(UUID id) implements UserCommand {}
