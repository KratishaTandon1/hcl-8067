package com.example.hrms.controller;

import com.example.hrms.model.Attendance;
import com.example.hrms.service.AttendanceService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/attendance")
public class AttendanceController {

    private final AttendanceService attendanceService;

    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping
    public ResponseEntity<List<Attendance>> getAttendance(
            @RequestParam Long employeeId,
            @RequestParam LocalDate date) {
        return ResponseEntity.ok(attendanceService.findByEmployeeAndDate(employeeId, date));
    }

    @PostMapping("/check-in")
    public ResponseEntity<Attendance> checkIn(@Valid @RequestBody Attendance attendance) {
        Attendance created = attendanceService.checkIn(attendance);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PatchMapping("/{id}/check-out")
    public ResponseEntity<Attendance> checkOut(
            @PathVariable Long id,
            @RequestBody Map<String, String> payload) {
        LocalTime checkOutTime = LocalTime.parse(payload.get("checkOutTime"));
        Attendance updated = attendanceService.checkOut(id, checkOutTime);
        return ResponseEntity.ok(updated);
    }
}