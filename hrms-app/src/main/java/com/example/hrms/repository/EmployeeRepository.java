package com.example.hrms.repository;

import com.example.hrms.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class EmployeeRepository {
    private final Map<Long, Employee> storage = new ConcurrentHashMap<>();
    private final AtomicLong idCounter = new AtomicLong(1);

    public List<Employee> findAll() {
        return new ArrayList<>(storage.values());
    }

    public Optional<Employee> findById(Long id) {
        return Optional.ofNullable(storage.get(id));
    }

    public Optional<Employee> findByEmail(String email) {
        return storage.values().stream()
                .filter(e -> e.getEmail().equalsIgnoreCase(email))
                .findFirst();
    }

    public Employee save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(idCounter.getAndIncrement());
        }
        storage.put(employee.getId(), employee);
        return employee;
    }

    public void deleteById(Long id) {
        storage.remove(id);
    }
}