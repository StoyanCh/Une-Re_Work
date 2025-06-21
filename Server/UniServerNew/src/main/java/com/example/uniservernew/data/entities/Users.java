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

    public User_Roles getUser_role() {
        return user_role;
    }

    public void setUser_role(User_Roles user_role) {
        this.user_role = user_role;
    }

    public String getUser_first_name() {
        return user_first_name;
    }

    public void setUser_first_name(String user_first_name) {
        this.user_first_name = user_first_name;
    }

    public String getUser_second_name() {
        return user_second_name;
    }

    public void setUser_second_name(String user_second_name) {
        this.user_second_name = user_second_name;
    }

    public String getUser_last_name() {
        return user_last_name;
    }

    public void setUser_last_name(String user_last_name) {
        this.user_last_name = user_last_name;
    }

    public String getUser_egn() {
        return user_egn;
    }

    public void setUser_egn(String user_egn) {
        this.user_egn = user_egn;
    }

    public String getUser_id_card_num() {
        return user_id_card_num;
    }

    public void setUser_id_card_num(String user_id_card_num) {
        this.user_id_card_num = user_id_card_num;
    }

    public Date getUser_birthday() {
        return user_birthday;
    }

    public void setUser_birthday(Date user_birthday) {
        this.user_birthday = user_birthday;
    }

    public String getUser_address_by_id_card() {
        return user_address_by_id_card;
    }

    public void setUser_address_by_id_card(String user_address_by_id_card) {
        this.user_address_by_id_card = user_address_by_id_card;
    }

    public String getUser_address_current() {
        return user_address_current;
    }

    public void setUser_address_current(String user_address_current) {
        this.user_address_current = user_address_current;
    }

    public String getUser_photo_path() {
        return user_photo_path;
    }

    public void setUser_photo_path(String user_photo_path) {
        this.user_photo_path = user_photo_path;
    }

    public String getUser_phone_number() {
        return user_phone_number;
    }

    public void setUser_phone_number(String user_phone_number) {
        this.user_phone_number = user_phone_number;
    }

    public String getUser_email_address_personal() {
        return user_email_address_personal;
    }

    public void setUser_email_address_personal(String user_email_address_personal) {
        this.user_email_address_personal = user_email_address_personal;
    }
}
