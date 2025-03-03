package org.os.application.query;

import java.util.UUID;

public record GetUserQuery(UUID id) implements UserQuery {}
