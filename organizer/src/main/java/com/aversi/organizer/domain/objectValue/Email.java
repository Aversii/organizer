package com.aversi.organizer.domain.objectValue;

import java.util.regex.Pattern;

public final class Email {
    private final String address;

    public Email(String address) {
        this.address = validateAndNormalize(address);
    }

    private String validateAndNormalize(String address) {
        if (address == null || address.isBlank()) {
            throw new IllegalArgumentException("Email address cannot be null or empty"); // should throw a custom error?
        }

        String normalizedEmail = address.trim().toLowerCase();

        if (!isValid(normalizedEmail)) {
            throw new IllegalArgumentException("Invalid email format");// should throw a custom error?
        }

        return normalizedEmail;
    }

    private boolean isValid(String email) {
        return Pattern.matches(
                "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$",
                email);
    }

    public String getAddress() {
        return address;
    }

}