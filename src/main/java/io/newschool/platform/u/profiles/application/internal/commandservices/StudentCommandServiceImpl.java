package io.newschool.platform.u.profiles.application.internal.commandservices;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StudentDni;
import io.newschool.platform.u.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u.profiles.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentCommandServiceImpl implements StudentCommandService {
    private final StudentRepository studentRepository;

    public StudentCommandServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Long handle(CreateStudentCommand command) {
        var studentDni = new StudentDni(command.dni());
        studentRepository.findByDni(studentDni).map(student -> {
           throw new IllegalArgumentException("Student with dni " + command.dni() + " already exists");
        });
        var student = new Student(
                command.name(),
                command.dni(),
                command.streetAddress(),
                command.gender(),
                command.birthDate(),
                command.specialty());
        studentRepository.save(student);
        return student.getId();
    }
}
