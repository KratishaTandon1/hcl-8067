package com.abes.hrmsdatabase.controller;

import com.abes.hrmsdatabase.model.Employee;
import com.abes.hrmsdatabase.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:5173/"})
@RequestMapping("/v1/user")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/")
    public String msg() {
        return "Chal gya project!! Khush ho jaaa";
    }

    @PostMapping("/addemp")
    public String addnewEmployee(@RequestBody Employee emp) {
        return employeeService.createNewEmployee(emp);
    }

    @GetMapping("/getall")
    public List<Employee> getallEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getbyid/{empid}")
    public Optional<Employee> getbyId(@PathVariable Long empid) {
        return employeeService.getById(empid);
    }

    @DeleteMapping("/deletebyid/{empid}")
    public String deleteById(@PathVariable Long empid) {
        return employeeService.deletebyid(empid);
    }

    @DeleteMapping("/deleteall")
    public String deleteall() {
        return employeeService.deleteall();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> payload) {
        String email = payload.get("email");
        String password = payload.get("password");

        Employee emp = employeeService.loginByEmail(email, password);
        if (emp != null) {
            return ResponseEntity.ok(emp);
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
    }
}