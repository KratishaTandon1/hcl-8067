package com.example.hrms.repository;

import com.example.hrms.model.Attendance;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AttendanceRepository {
    private final Map<Long, Attendance> storage = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Attendance> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Attendance> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public List<Attendance> findByEmployeeAndDate(Long employeeId, LocalDate date) {
        return storage.values().stream()
                .filter(a -> a.getEmployeeId().equals(employeeId) && a.getDate().equals(date))
                .toList();
    }

    public Attendance save(Attendance attendance) {
        if (attendance.getId() == null) {
            attendance.setId(idCounter.getAndIncrement());
        }
        storage.put(attendance.getId(), attendance);
        return attendance;
    }
}