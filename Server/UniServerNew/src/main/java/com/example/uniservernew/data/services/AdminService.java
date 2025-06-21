package com.example.uniservernew.data.services;

import com.example.uniservernew.data.entities.Sys_Admin;
import com.example.uniservernew.data.entities.Users;
import com.example.uniservernew.data.repositories.AdminRepository;
import com.example.uniservernew.data.repositories.SysAdminRepository;
import com.example.uniservernew.data.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AdminService {

    private final SysAdminRepository sysAdminRepository;
    private final UserRepository userRepository;

    public AdminService(SysAdminRepository sysAdminRepository, UserRepository userRepository) {
        this.sysAdminRepository = sysAdminRepository;
        this.userRepository = userRepository;
    }

    public void createSystemAdmin(Users newUser, String universityEmail) {

        Users savedUser = userRepository.save(newUser);

        Sys_Admin admin = new Sys_Admin();
        admin.sysAdmin = savedUser;
        admin.setIs_active(true);
        admin.setCreated_at(new Date());
        admin.setLast_login(new Date());

        sysAdminRepository.save(admin);

        System.out.println("✅ Системен администратор създаден: " + savedUser.getUser_email_address_personal());
    }
}
