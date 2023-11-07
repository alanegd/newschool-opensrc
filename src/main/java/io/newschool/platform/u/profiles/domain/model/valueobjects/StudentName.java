package io.newschool.platform.u.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentName(String name) {
    public StudentName() { this(null); }

    public StudentName {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }
}
