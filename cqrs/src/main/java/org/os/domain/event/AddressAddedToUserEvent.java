package org.os.domain.event;

import java.util.UUID;

public record AddressAddedToUserEvent(UUID userId, String address) {}
