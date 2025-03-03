package org.os.domain.event;

import java.util.UUID;

public record UserCreatedEvent(UUID userId, String fullName) {}
