package com.example.hrms.service;

import com.example.hrms.exception.DuplicateResourceException;
import com.example.hrms.exception.ResourceNotFoundException;
import com.example.hrms.model.Employee;
import com.example.hrms.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    public Employee create(Employee employee) {
        employeeRepository.findByEmail(employee.getEmail()).ifPresent(e -> {
            throw new DuplicateResourceException("Employee with email " + employee.getEmail() + " already exists.");
        });
        return employeeRepository.save(employee);
    }

    public Employee update(Long id, Employee updatedEmployee) {
        Employee existing = findById(id);
        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        return employeeRepository.save(existing);
    }

    public void delete(Long id) {
        findById(id); // Ensure it exists first
        employeeRepository.deleteById(id);
    }
}