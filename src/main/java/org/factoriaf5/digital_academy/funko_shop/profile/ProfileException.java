package org.factoriaf5.digital_academy.funko_shop.profile;

public class ProfileException extends RuntimeException{
    public ProfileException(String message) {
        super(message);
    }

    public ProfileException(String message, Throwable cause) {
        super(message, cause);
    }
}
