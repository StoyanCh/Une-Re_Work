package com.example.uniservernew.security;

import com.example.uniservernew.data.entities.Users;
import com.example.uniservernew.data.repositories.AdministrativeEmployeeRepository;
import com.example.uniservernew.data.repositories.SysAdminRepository;
import com.example.uniservernew.data.repositories.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    private final AdministrativeEmployeeRepository administrativeEmployeeRepository;
    private final SysAdminRepository sysAdminRepository;

    public SecurityService(AdministrativeEmployeeRepository repository, SysAdminRepository sysAdminRepository) {
        this.administrativeEmployeeRepository = repository;
        this.sysAdminRepository = sysAdminRepository;
    }

    public boolean isAuthoringAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) return false;

        Object principal = auth.getPrincipal();
        if (principal instanceof Users user) {
            String role = user.getUser_role().getU_role_name();
            boolean isWriter = "писател статия".equalsIgnoreCase(role);
            boolean isAdmin = administrativeEmployeeRepository.existsByAEmployee(user);
            return isWriter && isAdmin;
        }

        return false;
    }
    public boolean isSystemAdmin() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || !auth.isAuthenticated()) return false;

        Object principal = auth.getPrincipal();

        if (principal instanceof Users user) {
            boolean hasRole = user.getUser_role().getU_role_name().equalsIgnoreCase("системен админ");
            boolean isInTable = sysAdminRepository.existsBySysAdmin(user);
            return hasRole && isInTable;
        }

        return false;
    }

}
