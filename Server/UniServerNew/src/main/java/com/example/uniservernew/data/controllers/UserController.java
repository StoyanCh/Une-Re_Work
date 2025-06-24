package com.example.uniservernew.data.controllers;

import com.example.uniservernew.data.entities.*;
import com.example.uniservernew.data.repositories.UsersRepository;
import com.example.uniservernew.data.services.RoleAssignmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class UserController {

    // Администраторски роли при създаване
    private static final Set<String> ADMIN_ROLES = Set.of(
            "Секретар", "Счетоводител", "Писател", "Фронт Офис"
    );

    private final UsersRepository       usersRepo;
    private final RoleAssignmentService roleAssignmentService;

    public UserController(UsersRepository usersRepo,
                          RoleAssignmentService roleAssignmentService) {
        this.usersRepo            = usersRepo;
        this.roleAssignmentService = roleAssignmentService;
    }

    /**
     * 1) Създава базов Users запис.
     * 2) Ако roleName е в ADMIN_ROLES и е подаден adminEmail,
     *    създава и Administrative_Employee.
     */
    @PostMapping
    public ResponseEntity<Users> createUser(
            @RequestBody Users payload,
            @RequestParam(value = "adminEmail", required = false) String adminEmail
    ) {
        Users created = usersRepo.save(payload);

        String roleName = created.getUserRole().getRoleName();
        if (ADMIN_ROLES.contains(roleName) && adminEmail != null) {
            roleAssignmentService.createAdminEmployee(
                    created.getUserid(),
                    adminEmail
            );
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(created);
    }

    /**
     * Промотира вече създаден user в Teacher.
     * Пример: POST /api/users/42/teacher?status=true&email=uni@school.bg&titleIds=1,2,3
     */
    @PostMapping("/{userId}/teacher")
    public ResponseEntity<Teacher> promoteToTeacher(
            @PathVariable int userId,
            @RequestParam boolean status,
            @RequestParam String email,
            @RequestParam(required = false) Set<Integer> titleIds
    ) {
        Teacher teacher = roleAssignmentService.createTeacher(
                userId, status, email, titleIds
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(teacher);
    }

    /**
     * Промотира user в Student.
     * Пример: POST /api/users/42/student?year=2023-09-01&specialityId=5&facultyNumber=FN123&email=uni@student.bg
     */
    @PostMapping("/{userId}/student")
    public ResponseEntity<Student> promoteToStudent(
            @PathVariable int userId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date year,
            @RequestParam int specialityId,
            @RequestParam String facultyNumber,
            @RequestParam String email
    ) {
        Student student = roleAssignmentService.createStudent(
                userId, year, specialityId, facultyNumber, email
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(student);
    }

    /**
     * Промотира user в Sys_Admin.
     * Пример: POST /api/users/42/sysadmin?active=true&email=sys@admin.bg
     */
    @PostMapping("/{userId}/sysadmin")
    public ResponseEntity<Sys_Admin> promoteToSysAdmin(
            @PathVariable int userId,
            @RequestParam boolean active,
            @RequestParam String email
    ) {
        Sys_Admin sysAdmin = roleAssignmentService.createSysAdmin(
                userId, active, email
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(sysAdmin);
    }
}