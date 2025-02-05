package com.Learning.Project.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String position;
    private String department;
    private String country_code;
    private String phone_number;
    private String email;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;

    // geters
    public String getId() {
        return id;
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

    public String getDepartment() {
        return department;
    }


    public String getPhoneNumber() {
        return phone_number;
    }

    public String getCountryCode() {
        return country_code;
    }

    public String getEmail(){
        return email;
    }


    // Seters
    public void setPosition(String position) {
        this.position = position;
    }

    public void setEmail(String email) {
        this.email=email;
    }


    public void  setPhone_number(String phone_number){
        this.phone_number=phone_number;
    }
    public void setCountry_code(String country_code){
        this.country_code=country_code;
    }


    public void setDepartment(String department) {
        this.department = department;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", department='" + department + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}