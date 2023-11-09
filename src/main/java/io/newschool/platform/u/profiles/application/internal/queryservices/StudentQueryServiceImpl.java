package io.newschool.platform.u.profiles.application.internal.queryservices;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.domain.model.queries.GetStudentByDniQuery;
import io.newschool.platform.u.profiles.domain.model.queries.GetStudentByIdQuery;
import io.newschool.platform.u.profiles.domain.services.StudentQueryService;
import io.newschool.platform.u.profiles.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentQueryServiceImpl implements StudentQueryService {

    private final StudentRepository studentRepository;

    public StudentQueryServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> handle(GetStudentByIdQuery query) {
        return studentRepository.findById(query.studentId());
    }

}
