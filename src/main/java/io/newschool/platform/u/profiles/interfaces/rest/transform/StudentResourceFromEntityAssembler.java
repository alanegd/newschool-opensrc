package io.newschool.platform.u.profiles.interfaces.rest.transform;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.interfaces.rest.resources.StudentResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

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
