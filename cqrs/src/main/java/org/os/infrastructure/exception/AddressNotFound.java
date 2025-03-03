package org.os.infrastructure.exception;

public class AddressNotFound  extends RuntimeException {
    public AddressNotFound(String message) {
        super(message);
    }

    public AddressNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
