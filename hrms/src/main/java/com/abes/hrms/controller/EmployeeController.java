package com.abes.hrms.controller;

import com.abes.hrms.model.demoEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    @Autowired

    private demoEmployee demoEmployee;
    @GetMapping("/")
    public String welcome(){
        return "welcome to hrms app";
    }

    @GetMapping("/add")
    public int sum(){
        int result = demoEmployee.add();
        return result;
    }

    @GetMapping("/sqrt")
    public double getSquareRoot(){
        return demoEmployee.squareRoot();
    }

    @GetMapping("/gtn")
    public int gtn(){
        return demoEmployee.gtn();
    }
}
