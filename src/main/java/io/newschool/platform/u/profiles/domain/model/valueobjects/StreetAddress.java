package io.newschool.platform.u.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable
public record StreetAddress(String streetAddress) {
    public StreetAddress() {
        this(null);
    }

    public StreetAddress {
        if (streetAddress == null || streetAddress.isBlank()) {
            throw new IllegalArgumentException("Street address cannot be null or blank");
        }
    }
}
