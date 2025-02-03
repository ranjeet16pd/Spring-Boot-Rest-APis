package com.Learning.Project.repository;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface DepartmentRepo extends   MongoRepository<com.Learning.Project.model.Employee, String> {
}
