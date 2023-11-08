package io.newschool.platform.u.profiles.domain.model.aggregates;

import io.newschool.platform.u.profiles.domain.model.valueobjects.PersonName;
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
    private PersonName name;


    @Embedded
    private StudentDni dni;

    @Getter
    private String gender;

    @Getter
    private LocalDate birthDate;

    @Getter
    private String specialty;


    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "address_street")),
            @AttributeOverride(name = "number", column = @Column(name = "address_number")),
            @AttributeOverride(name = "city", column = @Column(name = "address_city")),
            @AttributeOverride(name = "zipCode", column = @Column(name = "address_zipCode")),
            @AttributeOverride(name = "country", column = @Column(name = "address_country"))
    })
    private StreetAddress address;

    public Student(String name, Long dni, String streetAddress, String gender, LocalDate birthDate, String specialty) {
        this.name = new PersonName(name);
        this.dni = new StudentDni(dni);
        this.address = new StreetAddress(streetAddress);
    }

    public Student() {

    }

    public void updateName(String name) {
        this.name = new PersonName(name);
    }

    public String getStreetAddress() {
        return this.address.getStreetAddress();
    }

    public Long getStudentDni() {
        return this.dni.dni();
    }

    public String getName() {
        return this.name.name();
    }
}
