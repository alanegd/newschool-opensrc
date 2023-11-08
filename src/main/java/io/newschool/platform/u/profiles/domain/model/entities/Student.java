package io.newschool.platform.u.profiles.domain.model.entities;

import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDate;

public class Student {
    @Id
    @Getter
    private Long id;
    private String name;
    private Long dni;
    private String gender;
    private String streetAddress;
    private LocalDate birthDate;
    private String specialty;
}
