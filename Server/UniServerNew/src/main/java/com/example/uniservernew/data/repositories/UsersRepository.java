package com.example.uniservernew.data.repositories;

import com.example.uniservernew.data.entities.Teacher;
import com.example.uniservernew.data.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
import java.util.Date;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    Optional<Users> findByUserEgn(String userEgn);

    List<Users> findByUserRole_RoleName(String roleName); // роля по име

    List<Users> findByUserBirthdayBetween(Date start, Date end); // търсене по година

    Optional<Users> findByEmailAddressPersonal(String emailAddressPersonal);

    Optional<Users> findByUserPhoneNumber(String userPhoneNumber);

    List<Users> findAllByOrderByUserLastNameAsc();
}