package io.newschool.platform.u.profiles.interfaces.rest.resources;

import java.time.LocalDate;

public record CreateStudentResource(
        String name,
        Long dni,
        String streetAddress,
        String gender,
        LocalDate birthDate,
        String specialty
) {
}
