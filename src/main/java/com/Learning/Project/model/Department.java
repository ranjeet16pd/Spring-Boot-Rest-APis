package com.Learning.Project.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "departments")
public class Department {
    @Id
    private String id;
    private String name;

    // Getters and Setters
}
