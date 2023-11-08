package io.newschool.platform.u.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StudentDni(

        Long dni
) {
    public StudentDni() { this(null); }
}
