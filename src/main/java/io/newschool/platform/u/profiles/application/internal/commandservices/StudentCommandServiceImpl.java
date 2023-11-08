package io.newschool.platform.u.profiles.application.internal.commandservices;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StreetAddress;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StudentDni;
import io.newschool.platform.u.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u.profiles.infrastructure.persistence.jpa.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Objects;

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

        var streetAddress = new StreetAddress(command.streetAddress());
        studentRepository.findByStreetAddress(streetAddress).map(student -> {
            throw new IllegalArgumentException("Student with street address " + command.streetAddress() + " already exists");
        });

        // Verify that student is not underage

        if (command.birthDate().isAfter(LocalDate.now().minusYears(18))) {
            throw new IllegalArgumentException("Student is underage");
        }

        // Verify that student is only male of female

        if (!command.gender().equals("Male") && !command.gender().equals("Female")){
            throw new IllegalArgumentException("Student gender can only be Male or Female, not " + command.gender());
        }

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
