package com.example.uniservernew.data.entities;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public int userid;

    @ManyToOne
    @JoinColumn(name = "user_role", nullable = false)
    private User_Role userRole;

    @Column(updatable = false, nullable = false, columnDefinition = "varchar(255)")
    public String userFirstName;

    @Column(updatable = false, nullable = false, columnDefinition = "varchar(255)")
    public String userSecondName;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    public String userLastName;

    @Column(length = 10, updatable = false, nullable = false, columnDefinition = "varchar(10)")
    public String userEgn;

    @Column(length = 8, nullable = false, columnDefinition = "varchar(8)")
    public String userIdCardNum;

    @Column(updatable = false, nullable = false, columnDefinition = "date")
    public Date userBirthday;

    @Column(updatable = false, nullable = false, columnDefinition = "varchar(255)")
    public String userAddressByIdCard;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    public String userAddressCurrent;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    public String userPhotoPath;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    public String userPhoneNumber;

    @Column(nullable = false, columnDefinition = "varchar(255)")
    public String emailAddressPersonal;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public User_Role getUserRole() {
        return userRole;
    }

    public void setUserRole(User_Role userRole) {
        this.userRole = userRole;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserSecondName() {
        return userSecondName;
    }

    public void setUserSecondName(String userSecondName) {
        this.userSecondName = userSecondName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserEgn() {
        return userEgn;
    }

    public void setUserEgn(String userEgn) {
        this.userEgn = userEgn;
    }

    public String getUserIdCardNum() {
        return userIdCardNum;
    }

    public void setUserIdCardNum(String userIdCardNum) {
        this.userIdCardNum = userIdCardNum;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserAddressByIdCard() {
        return userAddressByIdCard;
    }

    public void setUserAddressByIdCard(String userAddressByIdCard) {
        this.userAddressByIdCard = userAddressByIdCard;
    }

    public String getUserAddressCurrent() {
        return userAddressCurrent;
    }

    public void setUserAddressCurrent(String userAddressCurrent) {
        this.userAddressCurrent = userAddressCurrent;
    }

    public String getUserPhotoPath() {
        return userPhotoPath;
    }

    public void setUserPhotoPath(String userPhotoPath) {
        this.userPhotoPath = userPhotoPath;
    }

    public String getUserPhoneNumber() {
        return userPhoneNumber;
    }

    public void setUserPhoneNumber(String userPhoneNumber) {
        this.userPhoneNumber = userPhoneNumber;
    }

    public String getEmailAddressPersonal() {
        return emailAddressPersonal;
    }

    public void setEmailAddressPersonal(String emailAddressPersonal) {
        this.emailAddressPersonal = emailAddressPersonal;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return userid == users.userid && Objects.equals(userRole, users.userRole) && Objects.equals(userFirstName, users.userFirstName) && Objects.equals(userSecondName, users.userSecondName) && Objects.equals(userLastName, users.userLastName) && Objects.equals(userEgn, users.userEgn) && Objects.equals(userIdCardNum, users.userIdCardNum) && Objects.equals(userBirthday, users.userBirthday) && Objects.equals(userAddressByIdCard, users.userAddressByIdCard) && Objects.equals(userAddressCurrent, users.userAddressCurrent) && Objects.equals(userPhotoPath, users.userPhotoPath) && Objects.equals(userPhoneNumber, users.userPhoneNumber) && Objects.equals(emailAddressPersonal, users.emailAddressPersonal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid, userRole, userFirstName, userSecondName, userLastName, userEgn, userIdCardNum, userBirthday, userAddressByIdCard, userAddressCurrent, userPhotoPath, userPhoneNumber, emailAddressPersonal);
    }
}
