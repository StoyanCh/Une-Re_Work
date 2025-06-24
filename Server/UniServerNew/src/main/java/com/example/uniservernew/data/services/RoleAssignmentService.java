package com.example.uniservernew.data.services;

import com.example.uniservernew.data.entities.*;
import com.example.uniservernew.data.repositories.*;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleAssignmentService {

    private final UsersRepository                  usersRepo;
    private final TeacherRepository                teacherRepo;
    private final AcademicTitlesRepository         academicTitleRepo;
    private final StudentRepository                studentRepo;
    private final SpecialityRepository             specialityRepo;
    private final Sys_AdminRepository              sysAdminRepo;
    private final AdministrativeEmployeeRepository administrativeEmployeeRepo;

    @Transactional
    public Teacher createTeacher(int userId,
                                 boolean status,
                                 String email,
                                 Set<Integer> titleIds) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + userId));

        // (По желание) проверка за дублиране
        if (teacherRepo.existsById(new TeacherId(userId))) {
            throw new IllegalStateException("User is already a teacher: " + userId);
        }

        Teacher teacher = new Teacher();
        teacher.setTeacherId(new TeacherId(userId));
        teacher.setTeacher(user);
        teacher.setTeacherStatus(status);
        teacher.setTeacherEmailAddressUni(email);

        if (titleIds != null && !titleIds.isEmpty()) {
            Set<Academic_Title> titles = new HashSet<>(
                    academicTitleRepo.findAllById(titleIds)
            );
            teacher.setTeacherTitles(titles);
        }

        return teacherRepo.save(teacher);
    }

    @Transactional
    public Student createStudent(int userId,
                                 Date yearOfEnrolling,
                                 int specialityId,
                                 String facultyNumber,
                                 String email) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + userId));

        Speciality spec = specialityRepo.findById(specialityId)
                .orElseThrow(() -> new EntityNotFoundException("Speciality not found: " + specialityId));

        // (По желание) проверка за дублиране
        if (studentRepo.existsById(new StudentId(userId))) {
            throw new IllegalStateException("User is already a student: " + userId);
        }

        Student student = new Student();
        student.setStudentId(new StudentId(userId));
        student.setStudent(user);
        student.setYearOfEnrolling(yearOfEnrolling);
        student.setSpeciality(spec);
        student.setFacultyNumber(facultyNumber);
        student.setStudentEmailAddressUni(email);

        return studentRepo.save(student);
    }

    @Transactional
    public Sys_Admin createSysAdmin(int userId,
                                    boolean active,
                                    String email) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + userId));

        if (sysAdminRepo.existsById(new SysAdminId(userId))) {
            throw new IllegalStateException("User is already a sys_admin: " + userId);
        }

        Sys_Admin sysAdmin = new Sys_Admin();
        sysAdmin.setSysAdminId(new SysAdminId(userId));
        sysAdmin.setSysAdmin(user);
        sysAdmin.setActive(active);
        sysAdmin.setSysAdminEmailAddress(email);

        return sysAdminRepo.save(sysAdmin);
    }

    @Transactional
    public Administrative_Employee createAdminEmployee(int userId,
                                                       String email) {
        Users user = usersRepo.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found: " + userId));

        if (administrativeEmployeeRepo.existsById(new AdminEmployeeId(userId))) {
            throw new IllegalStateException("User is already an administrative_employee: " + userId);
        }

        Administrative_Employee adminEmp = new Administrative_Employee();
        adminEmp.setAdminEmployeeId(new AdminEmployeeId(userId));
        adminEmp.setAdministrativeEmployee(user);
        adminEmp.setAdministrativeEmployeeEmailUni(email);

        return administrativeEmployeeRepo.save(adminEmp);
    }
}