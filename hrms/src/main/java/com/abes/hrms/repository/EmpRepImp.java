package com.abes.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public class EmpRepImp implements  EmpRepo{


    @Override
    public double sqaureroot(double d) {
        double result=Math.sqrt(d);
        return  result;
    }

    @Override
    public String empDate() {
        return "";
    }

    @Override
    public int add(int a, int b) {
        return a + b;
    }

    @Override
    public  int gtn(int a, int b){
        if(a>b) return a;
        return b;
    }
}
