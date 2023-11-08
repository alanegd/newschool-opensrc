package io.newschool.platform.u.profiles.domain.services;

import io.newschool.platform.u.profiles.domain.model.commands.CreateStudentCommand;

public interface StudentCommandService {
    Long handle(CreateStudentCommand command);
}
