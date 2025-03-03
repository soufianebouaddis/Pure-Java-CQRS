package org.os.domain.event;

import java.util.UUID;

public record UserDeletedEvent(UUID userId) {}
