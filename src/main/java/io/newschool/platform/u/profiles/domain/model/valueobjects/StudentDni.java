package io.newschool.platform.u.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentDni(Long dni) {
    public StudentDni() { this(null); }

    public StudentDni {
        if (dni == null || dni < 0) {
            throw new IllegalArgumentException("Student dni cannot be null or negative");
        }
    }
}
