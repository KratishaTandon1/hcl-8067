package com.example.hrms.model;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

public class Attendance {
    private Long id;

    @NotNull(message = "Employee ID is mandatory")
    private Long employeeId;

    @NotNull(message = "Date is mandatory")
    private LocalDate date;

    @NotNull(message = "Check-in time is mandatory")
    private LocalTime checkInTime;

    private LocalTime checkOutTime;

    public Attendance() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getEmployeeId() { return employeeId; }
    public void setEmployeeId(Long employeeId) { this.employeeId = employeeId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public LocalTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalTime checkInTime) { this.checkInTime = checkInTime; }

    public LocalTime getCheckOutTime() { return checkOutTime; }
    public void setCheckOutTime(LocalTime checkOutTime) { this.checkOutTime = checkOutTime; }
}