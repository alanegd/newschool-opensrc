package io.newschool.platform.u.profiles.interfaces.rest.transform;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.interfaces.rest.resources.StudentResource;

public class StudentResourceFromEntityAssembler {
    public static StudentResource toResourceFromEntity(Student entity) {
        return new StudentResource(
                entity.getId(),
                entity.getName(),
                entity.getStudentDni(),
                entity.getGender(),
                entity.getStreetAddress(),
                entity.getBirthDate(),
                entity.getSpecialty()
        );
    }
}
