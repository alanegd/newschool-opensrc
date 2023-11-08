package io.newschool.platform.u.profiles.domain.model.queries;

import io.newschool.platform.u.profiles.domain.model.valueobjects.StudentDni;

public record GetStudentByDniQuery(StudentDni studentDni) {
}
