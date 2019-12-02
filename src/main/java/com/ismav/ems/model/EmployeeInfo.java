package com.ismav.ems.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class EmployeeInfo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    @NotBlank(message = "First Name can't be null")
    private String employeeFirstName;

    private String employeeMiddleName;

    @NotBlank(message = "Last Name can't be null")
    private String employeeLastName;

    @NotBlank(message = "Company Name can't be null")
    private String employeeCompany;

    @NotBlank(message = "Designation can't be null")
    private String employeeDesignation;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeFirstName() {
        return employeeFirstName;
    }

    public void setEmployeeFirstName(String employeeFirstName) {
        this.employeeFirstName = employeeFirstName;
    }

    public String getEmployeeMiddleName() {
        return employeeMiddleName;
    }

    public void setEmployeeMiddleName(String employeeMiddleName) {
        this.employeeMiddleName = employeeMiddleName;
    }

    public String getEmployeeLastName() {
        return employeeLastName;
    }

    public void setEmployeeLastName(String employeeLastName) {
        this.employeeLastName = employeeLastName;
    }

    public String getEmployeeCompany() {
        return employeeCompany;
    }

    public void setEmployeeCompany(String employeeCompany) {
        this.employeeCompany = employeeCompany;
    }

    public String getEmployeeDesignation() {
        return employeeDesignation;
    }

    public void setEmployeeDesignation(String employeeDesignation) {
        this.employeeDesignation = employeeDesignation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeInfo that = (EmployeeInfo) o;
        return Objects.equals(employeeId, that.employeeId) &&
                Objects.equals(employeeFirstName, that.employeeFirstName) &&
                Objects.equals(employeeMiddleName, that.employeeMiddleName) &&
                Objects.equals(employeeLastName, that.employeeLastName) &&
                Objects.equals(employeeCompany, that.employeeCompany) &&
                Objects.equals(employeeDesignation, that.employeeDesignation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeId, employeeFirstName, employeeMiddleName, employeeLastName, employeeCompany, employeeDesignation);
    }

    @Override
    public String toString() {
        return "EmployeeInfo{" +
                "employeeId=" + employeeId +
                ", employeeFirstName='" + employeeFirstName + '\'' +
                ", employeeMiddleName='" + employeeMiddleName + '\'' +
                ", employeeLastName='" + employeeLastName + '\'' +
                ", employeeCompany='" + employeeCompany + '\'' +
                ", employeeDesignation='" + employeeDesignation + '\'' +
                '}';
    }
}
