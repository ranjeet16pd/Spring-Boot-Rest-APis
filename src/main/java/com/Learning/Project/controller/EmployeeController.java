package com.Learning.Project.controller;

import com.Learning.Project.dto.request.EmployeeRequestDTO;
import com.Learning.Project.utils.ApiResponse;
import com.Learning.Project.dto.response.EmployeeResponseDTO;
import com.Learning.Project.model.Employee;
import com.Learning.Project.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<EmployeeResponseDTO>>> getAllEmployees() {
        List<EmployeeResponseDTO> employees = employeeService.getAllEmployees().stream()
                .map(employeeService::convertToDTO)
                .collect(Collectors.toList());
        ApiResponse<List<EmployeeResponseDTO>> response = new ApiResponse<>(200, employees);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> getEmployeeById(@PathVariable String id) {
        return employeeService.getEmployeeById(id)
                .map(employeeService::convertToDTO)
                .map(employee -> ResponseEntity.ok(new ApiResponse<>(200, employee)))
                .orElse(ResponseEntity.status(404).body(new ApiResponse<>(404, null)));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> createEmployee(@RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee employee = new Employee();
        employee.setName(employeeRequestDTO.getName());
        employee.setPosition(employeeRequestDTO.getPosition());
        employee.setDepartment(employeeRequestDTO.getDepartment());
        employee.setCreatedAt(LocalDateTime.now());
        employee.setUpdatedAt(LocalDateTime.now());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setCountry_code(employeeRequestDTO.getCountry_code());
        employee.setEmail(employeeRequestDTO.getEmail());
        employee.setPhone_number(employeeRequestDTO.getPhone_number());



        Employee createdEmployee = employeeService.saveEmployee(employee);

        EmployeeResponseDTO responseDTO = employeeService.convertToDTO(createdEmployee);
        return ResponseEntity.status(201).body(new ApiResponse<>(201, responseDTO));
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteEmployee(@PathVariable String id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok(new ApiResponse<>(200, "Employee deleted successfully"));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse<>(404, "Employee not found"));
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<EmployeeResponseDTO>> updateEmployee(@PathVariable String id, @RequestBody EmployeeRequestDTO employeeRequestDTO) {
        Employee updatedEmployee = new Employee();
        updatedEmployee.setName(employeeRequestDTO.getName());
        updatedEmployee.setPosition(employeeRequestDTO.getPosition());
        updatedEmployee.setDepartment(employeeRequestDTO.getDepartment());
        updatedEmployee.setEmail(employeeRequestDTO.getEmail());
        updatedEmployee.setCountry_code(employeeRequestDTO.getCountry_code());
        updatedEmployee.setPhone_number(employeeRequestDTO.getPhone_number());
        updatedEmployee.setUpdatedAt(LocalDateTime.now());

        Optional<Employee> updatedEmployeeResult = employeeService.updateEmployee(id, updatedEmployee);
        if (updatedEmployeeResult.isPresent()) {
            EmployeeResponseDTO responseDTO = employeeService.convertToDTO(updatedEmployeeResult.get());
            return ResponseEntity.ok(new ApiResponse<>(200, responseDTO));
        } else {
            return ResponseEntity.status(404).body(new ApiResponse<>(404, null));
        }
    }

}
