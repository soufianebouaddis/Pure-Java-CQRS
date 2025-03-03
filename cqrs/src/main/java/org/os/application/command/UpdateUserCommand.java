package org.os.application.command;

import java.util.UUID;

public record UpdateUserCommand(UUID id, String fullName) implements UserCommand {}

