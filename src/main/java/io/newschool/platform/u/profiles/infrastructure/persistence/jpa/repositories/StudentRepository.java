package io.newschool.platform.u.profiles.infrastructure.persistence.jpa.repositories;

import io.newschool.platform.u.profiles.domain.model.aggregates.Student;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StreetAddress;
import io.newschool.platform.u.profiles.domain.model.valueobjects.StudentDni;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findByDni(StudentDni studentDni);
    Optional<Student> findByStreetAddress(StreetAddress streetAddress);
}
