package com.Learning.Project.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String position;
    private String department;
}
