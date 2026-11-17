package com.abesproject.hclhrms.controller;

import com.abesproject.hclhrms.EmployeeServiceImp;
import com.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS}, allowedHeaders = "*")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @GetMapping("/")
    public String home() {
        return "HCLS HRMS API is running successfully!";
    }

    // React form se POST request yahan aayegi
    @PostMapping("/addemp")
    public String addnewEmployee(@RequestBody Employee employee) {
        return employeeServiceImp.addEmp(employee);
    }

    @GetMapping("/getemp")
    public List<Employee> getEmp() {
        return employeeServiceImp.getemp();
    }

    @GetMapping("/getempbyid")
    public Employee getempbyid() {
        return employeeServiceImp.getEmpbyid();
    }

    @GetMapping("/bulk")
    public String addBulkEmployees() {
        return employeeServiceImp.addEmpBulk();
    }

    @DeleteMapping("/deletebyid")
    public String deletebyid() {
        return employeeServiceImp.deletebyid();
    }

    @PatchMapping("/updatebyid")
    public String updatebyid() {
        return employeeServiceImp.updatebyid();
    }
}