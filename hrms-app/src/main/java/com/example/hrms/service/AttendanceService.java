package com.example.hrms.service;

import com.example.hrms.exception.DuplicateResourceException;
import com.example.hrms.exception.ResourceNotFoundException;
import com.example.hrms.model.Attendance;
import com.example.hrms.repository.AttendanceRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;
    private final EmployeeService employeeService;

    public AttendanceService(AttendanceRepository attendanceRepository, EmployeeService employeeService) {
        this.attendanceRepository = attendanceRepository;
        this.employeeService = employeeService;
    }

    public List<Attendance> findByEmployeeAndDate(Long employeeId, LocalDate date) {
        return attendanceRepository.findByEmployeeAndDate(employeeId, date);
    }

    public Attendance checkIn(Attendance attendance) {
        // Verify that the employee exists
        employeeService.findById(attendance.getEmployeeId());

        // Rule: One check-in per employee per workday
        List<Attendance> existing = attendanceRepository.findByEmployeeAndDate(
                attendance.getEmployeeId(), attendance.getDate());
        if (!existing.isEmpty()) {
            throw new DuplicateResourceException("Employee already checked in for date: " + attendance.getDate());
        }

        return attendanceRepository.save(attendance);
    }

    public Attendance checkOut(Long attendanceId, LocalTime checkOutTime) {
        Attendance record = attendanceRepository.findById(attendanceId)
                .orElseThrow(() -> new ResourceNotFoundException("Attendance record not found with id: " + attendanceId));

        record.setCheckOutTime(checkOutTime);
        return attendanceRepository.save(record);
    }
}