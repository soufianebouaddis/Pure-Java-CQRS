package org.os.domain.event;

import java.util.UUID;

public record UserUpdatedEvent(UUID userId, String fullName) {}