package com.example.hrms;

import com.example.hrms.model.Employee;
import com.example.hrms.model.Attendance;
import com.example.hrms.service.EmployeeService;
import com.example.hrms.service.AttendanceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class HrmsApplication {

    public static void main(String[] args) {
        SpringApplication.run(HrmsApplication.class, args);
        System.out.println("welcome to hrms");
    }

    @Bean
    CommandLineRunner initData(EmployeeService employeeService, AttendanceService attendanceService) {
        return args -> {
            Employee e1 = new Employee();
            e1.setName("Jane Doe");
            e1.setEmail("jane.doe@example.com");
            e1.setDepartment("Engineering");
            employeeService.create(e1);

            Employee e2 = new Employee();
            e2.setName("John Smith");
            e2.setEmail("john.smith@example.com");
            e2.setDepartment("HR");
            employeeService.create(e2);

            Attendance a1 = new Attendance();
            a1.setEmployeeId(1L);
            a1.setDate(LocalDate.now());
            a1.setCheckInTime(LocalTime.of(9, 0));
            attendanceService.checkIn(a1);

            System.out.println("--> Sample HRMS data loaded into memory!");
        };
    }
}