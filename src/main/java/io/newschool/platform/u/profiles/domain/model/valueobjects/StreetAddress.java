package io.newschool.platform.u.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StreetAddress(
        String streetAddress
) {
    public StreetAddress() {
        this(null);
    }

    public String getStreetAddress() {
        return streetAddress;
    }
}
