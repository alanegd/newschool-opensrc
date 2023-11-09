package io.newschool.platform.u.profiles.interfaces.rest;

import io.newschool.platform.u.profiles.domain.model.queries.GetStudentByIdQuery;
import io.newschool.platform.u.profiles.domain.services.StudentCommandService;
import io.newschool.platform.u.profiles.domain.services.StudentQueryService;
import io.newschool.platform.u.profiles.interfaces.rest.resources.CreateStudentResource;
import io.newschool.platform.u.profiles.interfaces.rest.resources.StudentResource;
import io.newschool.platform.u.profiles.interfaces.rest.transform.CreateStudentCommandFromResourceAssembler;
import io.newschool.platform.u.profiles.interfaces.rest.transform.StudentResourceFromEntityAssembler;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Students Controller.
 * <p>
 * This class is the entry point for all the REST API calls related to students.
 * It is responsible for handling the requests and delegating the processing to the appropriate services.
 * It also transforms the data from the request to the appropriate commands and vice versa.
 * The endpoints are:
 *  *     <ul>
 *  *         <li>POST /api/v1/students</li>
 *  *     </ul>
 * </p>
 * @author EGD
 */
@RestController
@RequestMapping(value = "/api/v1/students", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Students", description = "Students Management Endpoints")
public class StudentsController {
    private final StudentQueryService studentQueryService;
    private final StudentCommandService studentCommandService;

    public StudentsController(StudentQueryService studentQueryService, StudentCommandService studentCommandService) {
        this.studentQueryService = studentQueryService;
        this.studentCommandService = studentCommandService;
    }


    /**
     * Creates a new student.
     *
     * @param createStudentResource the resource containing the data for the student to be created
     * @return the created student resource
     * @see CreateStudentResource
     * @see StudentResource
     * @author EGD
     */
    @PostMapping
    public ResponseEntity<StudentResource> createStudent(@RequestBody CreateStudentResource createStudentResource) {
        var createStudentCommand = CreateStudentCommandFromResourceAssembler.toCommandFromResource(createStudentResource);
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
