package org.os.infrastructure.event;

import java.util.*;
import java.util.function.Consumer;

public class EventBus {
    private final Map<Class<?>, List<Consumer<?>>> listeners = new HashMap<>();

    public <T> void subscribe(Class<T> eventType, Consumer<T> handler) {
        listeners.computeIfAbsent(eventType, k -> new ArrayList<>()).add(handler);
    }

    public <T> void publish(T event) {
        List<Consumer<?>> handlers = listeners.getOrDefault(event.getClass(), List.of());
        for (Consumer<?> handler : handlers) {
            ((Consumer<T>) handler).accept(event);
        }
    }
}

