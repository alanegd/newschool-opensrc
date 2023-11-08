package io.newschool.platform.u.profiles.interfaces.rest.transform;

import io.newschool.platform.u.profiles.domain.model.commands.CreateStudentCommand;
import io.newschool.platform.u.profiles.interfaces.rest.resources.CreateStudentResource;

public class CreateStudentCommandFromResourceAssembler {
    public static CreateStudentCommand toCommandFromResource(CreateStudentResource resource) {
        return new CreateStudentCommand(resource.name(), resource.dni(), resource.streetAddress(), resource.gender(), resource.birthDate(), resource.specialty());
    }
}
