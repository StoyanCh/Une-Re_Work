package com.example.uniservernew.data.entities;

import com.example.uniservernew.data.entities.AdminEmployeeId;
import com.example.uniservernew.data.entities.Users;
import jakarta.persistence.*;

@Entity
@Table(name = "administrative_employee")
public class Administrative_Employee {

    @EmbeddedId
    private AdminEmployeeId adminEmployeeId;

    @MapsId("userId")
    @ManyToOne
    @JoinColumn(name = "a_employee_id")
    private Users administrativeEmployee;

    @Column(nullable = false, updatable = false, columnDefinition = "varchar(255)")
    private String administrativeEmployeeEmailUni;

    public AdminEmployeeId getAdminEmployeeId() {
        return adminEmployeeId;
    }

    public void setAdminEmployeeId(AdminEmployeeId adminEmployeeId) {
        this.adminEmployeeId = adminEmployeeId;
    }

    public Users getAdministrativeEmployee() {
        return administrativeEmployee;
    }

    public void setAdministrativeEmployee(Users administrativeEmployee) {
        this.administrativeEmployee = administrativeEmployee;
    }

    public String getAdministrativeEmployeeEmailUni() {
        return administrativeEmployeeEmailUni;
    }

    public void setAdministrativeEmployeeEmailUni(String administrativeEmployeeEmailUni) {
        this.administrativeEmployeeEmailUni = administrativeEmployeeEmailUni;
    }
}