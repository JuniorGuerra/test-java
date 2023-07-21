package com.amaris.test.EmployeeSalaryManager.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", employeeName='" + employeeName + '\'' +
                ", employeeSalary=" + employeeSalary +
                ", employeeAge=" + employeeAge +
                ", profileImage='" + profileImage + '\'' +
                ", employeeAnualSalary=" + employeeAnnualSalary +
                '}';
    }

    private int id;
    @JsonProperty("employee_name")
    private String employeeName;
    @JsonProperty("employee_salary")
    private double employeeSalary;
    @JsonProperty("employee_annual_salary")
    private double employeeAnnualSalary;
    @JsonProperty("employee_age")
    private int employeeAge;
    @JsonProperty("profile_image")
    private String profileImage;


    public double getEmployeeAnnualSalary() {
        return employeeAnnualSalary;
    }

    public void setEmployeeAnnualSalary(double employeeAnnualSalary) {
        this.employeeAnnualSalary = employeeAnnualSalary;
    }


    public Employee() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public int getEmployeeAge() {
        return employeeAge;
    }

    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }



}
