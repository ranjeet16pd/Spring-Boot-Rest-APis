package com.Learning.Project.dto.request;

import java.time.LocalDateTime;

public class EmployeeRequestDTO {
    private String name;
    private String position;
    private String department;

    // Constructors
    public EmployeeRequestDTO() {}

    public EmployeeRequestDTO(String name, String position, String department) {
        this.name = name;
        this.position = position;
        this.department = department;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // toString method for debugging
    @Override
    public String toString() {
        return "EmployeeRequestDTO{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
