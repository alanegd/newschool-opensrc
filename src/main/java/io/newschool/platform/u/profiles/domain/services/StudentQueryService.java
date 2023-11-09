package io.newschool.platform.u.profiles.domain.services;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.domain.model.queries.GetStudentByDniQuery;
import io.newschool.platform.u.profiles.domain.model.queries.GetStudentByIdQuery;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByIdQuery query);

}
