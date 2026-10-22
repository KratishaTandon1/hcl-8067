package com.abes.hrms.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepo {
    double sqaureroot(double d);
    String empDate();

    int add(int a, int b);
    int gtn(int a, int b);
}
