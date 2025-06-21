package com.example.uniservernew.data.services;

import com.example.uniservernew.data.entities.*;
import com.example.uniservernew.data.repositories.*;
import jakarta.transaction.Transactional;

import java.util.Date;
import java.util.Set;

public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;
    private final AdministrativeEmployeeRepository administrativeEmployeeRepository;
    private final SysAdminRepository sysAdminRepository;

    public UserService(UserRepository userRepository,
                       StudentRepository studentRepository,
                       TeacherRepository teacherRepository,
                       AdministrativeEmployeeRepository administrativeEmployeeRepository,
                       SysAdminRepository sysAdminRepository) {
        this.userRepository = userRepository;
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
        this.administrativeEmployeeRepository = administrativeEmployeeRepository;
        this.sysAdminRepository = sysAdminRepository;
    }

    @Transactional
    public void createUser(Users user,
                           String selectedRole,
                           String academicEmail,
                           Date enrollmentDate,
                           String facultyNumber,
                           Specialities speciality,
                           Set<Academic_Titles> titles) {

        userRepository.save(user);

        switch (selectedRole.toLowerCase()) {
            case "student" -> {
                Students student = new Students();
                student.setStudent(user);
                student.setStudent_email_address_uni(academicEmail);
                student.setFaculty_number(facultyNumber);
                student.setSpeciality(speciality);
                student.setYear_of_enrolling(enrollmentDate);
                studentRepository.save(student);
            }

            case "teacher" -> {
                Teachers teacher = new Teachers();
                teacher.setTeacher(user);
                teacher.setTeacher_email_address_uni(academicEmail);
                teacher.setTeacher_status(true);
                teacher.setTeacher_titles(titles);
                teacherRepository.save(teacher);
            }

            case "administrative_employee" -> {
                Administrative_Employee administrativeEmployee = new Administrative_Employee();
                administrativeEmployee.setA_employee(user);
                administrativeEmployee.setA_employee_email_address_uni(academicEmail);
                administrativeEmployeeRepository.save(administrativeEmployee);
            }

            case "sys_admin" -> {
                Sys_Admin sys = new Sys_Admin();
                sys.sysAdmin = user;
                sys.setIs_active(true);
                sys.setCreated_at(new Date());
                sys.setLast_login(new Date());
                sysAdminRepository.save(sys);
            }

            default -> throw new IllegalArgumentException("Непозната роля: " + selectedRole);
        }

        System.out.println("🧾 Потребител създаден с роля: " + selectedRole);
    }
}
