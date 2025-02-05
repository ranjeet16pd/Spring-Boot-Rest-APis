package com.Learning.Project.dto.request;

import java.time.LocalDateTime;

public class EmployeeRequestDTO {
    private String name;
    private String position;
    private String department;
    private String email;
    private String country_code;
    private String phone_number;

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


    public  void setEmail(String email){
        this.email=email;
    }

    public void setCountry_code(String country_code){
        this.country_code=country_code;
    }

    public void setPhone_number(String phone_number){
        this.phone_number=phone_number;
    }

    public String  getPhone_number(){
        return phone_number;
    }

    public String getCountry_code() {
            return country_code;
    }

    public String getEmail() {
        return email;
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
