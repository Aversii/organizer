package com.aversi.organizer.domain.objectValue;

import jakarta.persistence.Embeddable;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.regex.Pattern;

@Embeddable
public class Password {

    private static final Pattern UPPER_CASE = Pattern.compile("[A-Z]");
    private static final Pattern LOWER_CASE = Pattern.compile("[a-z]");
    private static final Pattern DIGIT = Pattern.compile("[0-9]");
    private static final Pattern SPECIAL_CHAR = Pattern.compile("[!@#$%^&*(),.?\":{}|<>]");
    
    private String passwordData;

    protected Password() {
    }

    public Password(String rawPassword, PasswordEncoder passwordEncoder) {
        validate(rawPassword);
        this.passwordData = passwordEncoder.encode(rawPassword);
    }

    private void validate(String rawPassword) {
        if (rawPassword == null || rawPassword.length() < 8 ||
            !UPPER_CASE.matcher(rawPassword).find() ||
            !LOWER_CASE.matcher(rawPassword).find() ||
            !DIGIT.matcher(rawPassword).find() ||
            !SPECIAL_CHAR.matcher(rawPassword).find()) {
            throw new IllegalArgumentException("Senha não atende aos requisitos de segurança.");
        }
    }

    public boolean matches(String rawPassword, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(rawPassword, this.passwordData);
    }

    public String getEncodedPassword() {
        return passwordData;
    }
}
