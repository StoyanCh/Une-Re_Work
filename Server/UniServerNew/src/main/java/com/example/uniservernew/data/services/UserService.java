package com.example.uniservernew.data.services;

import com.example.uniservernew.data.entities.Users;
import com.example.uniservernew.data.repositories.UsersRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    public final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Optional<Users> findByUserEgn(String userEgn) {
        return usersRepository.findByUserEgn(userEgn);
    }

    public List <Users> findByUserRole_RoleName(String roleName) {
        return usersRepository.findByUserRole_RoleName(roleName);
    }


}
