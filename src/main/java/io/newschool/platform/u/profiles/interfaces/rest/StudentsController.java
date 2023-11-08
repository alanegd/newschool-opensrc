package io.newschool.platform.u.profiles.interfaces.rest;

import io.newschool.platform.u.profiles.domain.model.queries.GetStudentByIdQuery;
import io.newschool.platform.u.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u.profiles.domain.services.StudentQueryService;
import io.newschool.platform.u.profiles.interfaces.rest.resources.CreateStudentResource;
import io.newschool.platform.u.profiles.interfaces.rest.resources.StudentResource;
import io.newschool.platform.u.profiles.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import io.newschool.platform.u.profiles.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
public class StudentsController {
    private final StudentQueryService studentQueryService;
    private final StudentCommandService studentCommandService;

    public StudentsController(StudentQueryService studentQueryService, StudentCommandService studentCommandService) {
        this.studentQueryService = studentQueryService;
        this.studentCommandService = studentCommandService;
    }

    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource resource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(resource);
        var studentId = studentCommandService.handle(createStudentCommand);
        if (studentId == 0L) {
            return ResponseEntity.badRequest().build();
        }
        var getStudentByIdQuery = new GetStudentByIdQuery(studentId);
        var student = studentQueryService.handle(getStudentByIdQuery);

        if (student.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        var studentResource = StudentResourceFromEntityAssembler.toResourceFromEntity(student.get());
        return new ResponseEntity<>(studentResource, HttpStatus.CREATED);
    }
}
