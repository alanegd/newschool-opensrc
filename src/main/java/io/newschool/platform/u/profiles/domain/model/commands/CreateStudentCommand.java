package io.newschool.platform.u.profiles.domain.model.commands;

import java.time.LocalDate;

public record CreateStudentCommand(String name, Long dni, String streetAddress, String gender, LocalDate birthDate, String specialty) {
}
