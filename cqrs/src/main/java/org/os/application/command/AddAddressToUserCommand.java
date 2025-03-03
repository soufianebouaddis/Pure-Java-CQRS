package org.os.application.command;

import java.util.UUID;

public record AddAddressToUserCommand(UUID userId, String addressName) implements UserCommand {}
