package com.Learning.Project.service;

import com.Learning.Project.dto.response.EmployeeResponseDTO;
import com.Learning.Project.model.Employee;
import com.Learning.Project.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(String id) {
        return employeeRepository.findById(id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


    public boolean deleteEmployee(String id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            employeeRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public Optional<Employee> updateEmployee(String id, Employee updatedEmployee) {
        return employeeRepository.findById(id).map(existingEmployee -> {
            if (updatedEmployee.getName() != null) {
                existingEmployee.setName(updatedEmployee.getName());
            }
            if (updatedEmployee.getPosition() != null) {
                existingEmployee.setPosition(updatedEmployee.getPosition());
            }
            if (updatedEmployee.getDepartment() != null) {
                existingEmployee.setDepartment(updatedEmployee.getDepartment());
            }
            if (updatedEmployee.getEmail() != null) {
                existingEmployee.setEmail(updatedEmployee.getEmail());
            }
            if (updatedEmployee.getCountryCode() != null) {
                existingEmployee.setCountry_code(updatedEmployee.getCountryCode());
            }
            if (updatedEmployee.getPhoneNumber() != null) {
                existingEmployee.setPhone_number(updatedEmployee.getPhoneNumber());
            }
            existingEmployee.setUpdatedAt(updatedEmployee.getUpdatedAt());

            return employeeRepository.save(existingEmployee);
        });
    }

    public EmployeeResponseDTO convertToDTO(Employee employee) {
        EmployeeResponseDTO dto = new EmployeeResponseDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());
        dto.setPosition(employee.getPosition());
        dto.setDepartment(employee.getDepartment());
        dto.setCountry_code(employee.getCountryCode());
        dto.setCountry_code(employee.getCountryCode());
        dto.setEmail(employee.getEmail());


        return dto;
    }
}
