package io.newschool.platform.u.profiles.interfaces.rest.resources;

import java.time.LocalDate;

// Acá se colocan los valores a retornar por el response
public record StudentResource(
        Long id,
        String name,
        Long dni,
        String streetAddress,
        String gender,
        LocalDate birthDate,
        String specialty
) {
}
