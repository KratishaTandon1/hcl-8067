package com.abesproject.hclhrms.entity;

public class Employee {
    private long emp_id;
    private String emp_name;
    private String designation;
    private String progStack;
    private String email;
    private String password;

    // 1. Default constructor
    public Employee() {
    }

    // 2. 5 arguments wala constructor (purane code ke liye)
    public Employee(long emp_id, String emp_name, String designation, String progStack, String email) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.designation = designation;
        this.progStack = progStack;
        this.email = email;
    }

    // 3. 6 arguments wala constructor (password ke sath - iski kami thi)
    public Employee(long emp_id, String emp_name, String designation, String progStack, String email, String password) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.designation = designation;
        this.progStack = progStack;
        this.email = email;
        this.password = password;
    }

    public long getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(long emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmp_name() {
        return emp_name;
    }

    public void setEmp_name(String emp_name) {
        this.emp_name = emp_name;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getProgStack() {
        return progStack;
    }

    public void setProgStack(String progStack) {
        this.progStack = progStack;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}