package com.abes.hrms.model;

import com.abes.hrms.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class demoEmployee {
    @Autowired
    private EmpRepo emprepo;


    public int add(int a, int b) {
        return emprepo.add(a, b);
    }

    public int add() {
        return emprepo.add(20, 40);
    }
    public double squareRoot(){
        return emprepo.sqaureroot(2000);
    }
    public int gtn(){
        return emprepo.gtn(55,60);
    }
}
