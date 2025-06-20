package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int user_id;

    @ManyToOne
    @JoinColumn(name = "user_role", nullable = false)
    public User_Roles user_role;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String user_first_name;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String user_second_name;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    public String user_last_name;

    @Column(length = 10, updatable = false,nullable = false,columnDefinition = "varchar(10)")
    public String user_egn;

    @Column(length = 8, nullable = false,columnDefinition = "varchar(8)")
    public String user_id_card_num;

    @Column(updatable = false, nullable = false, columnDefinition = "date")
    public Date user_birthday;

    @Column(updatable = false,nullable = false,columnDefinition = "varchar(255)")
    public String user_address_by_id_card;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    public String user_address_current;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    public String user_photo_path;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    public String user_phone_number;

    @Column(nullable = false,columnDefinition = "varchar(255)")
    public String user_email_address_personal;
}
