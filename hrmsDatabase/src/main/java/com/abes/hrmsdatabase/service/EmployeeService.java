package com.abes.hrmsdatabase.service;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public String createNewEmployee(Employee newEmp) {
        employeeRepository.save(newEmp);
        return "Employee is added successfully";
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getById(long id) {
        return employeeRepository.findById(id);
    }

    public String deletebyid(long id) {
        employeeRepository.deleteById(id);
        return "Done";
    }

    public String deleteall() {
        employeeRepository.deleteAll();
        return "Done";
    }

    public String login(long empid, String password) {
        Optional<Employee> empOpt = employeeRepository.findById(empid);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            if (emp.getPassword() != null && emp.getPassword().equals(password)) {
                return "Login Successful";
            } else {
                return "Invalid Password";
            }
        }
        return "Employee not found";
    }

    public Employee loginByEmail(String email, String password) {
        Optional<Employee> empOpt = employeeRepository.findByEmail(email);
        if (empOpt.isPresent()) {
            Employee emp = empOpt.get();
            if (emp.getPassword() != null && emp.getPassword().equals(password)) {
                return emp;
            }
        }
        return null;
    }

    public String verification(Employee emp) {
        if (emp == null) {
            return "Employee data missing";
        }
        return login(emp.getEmp_id(), emp.getPassword());
    }
}