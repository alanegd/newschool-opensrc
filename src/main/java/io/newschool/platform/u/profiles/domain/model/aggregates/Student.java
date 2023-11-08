package io.newschool.platform.u.profiles.domain.model.aggregates;

import io.newschool.platform.u.profiles.domain.model.valueobjects.StudentName;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StreetAddress;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StudentDni;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Student extends AbstractAggregateRoot<Student> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Embedded
    private StudentName name;

    @Embedded
    private StudentDni dni;

    @Getter
    private String gender;

    @Getter
    private LocalDate birthDate;

    @Getter
    private String specialty;

   @Embedded
    private StreetAddress streetAddress;

    public Student(String name, Long dni, String streetAddress, String gender, LocalDate birthDate, String specialty) {
        this.name = new StudentName(name);
        this.dni = new StudentDni(dni);
        this.streetAddress = new StreetAddress(streetAddress);
        this.gender = gender;
        this.birthDate = birthDate;
        this.specialty = specialty;
    }

    public Student() {

    }

    public String getName() {
        return this.name.name();
    }

    public Long getStudentDni() {

        return this.dni.dni();
    }

    public String getStreetAddress() {
        return this.streetAddress.streetAddress();
    }
}
