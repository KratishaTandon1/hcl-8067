package com.abesproject.hclhrms.repository;

import com.abesproject.hclhrms.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class EmpRepInf implements EmployeeRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // MySQL result ko Employee object mein convert karne ke liye mapper
    private final RowMapper<Employee> rowMapper = new RowMapper<Employee>() {
        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Employee(
                    rs.getLong("emp_id"),
                    rs.getString("emp_name"),
                    rs.getString("designation"),
                    rs.getString("prog_stack"),
                    rs.getString("email"),
                    rs.getString("password")
            );
        }
    };

    @Override
    public String addEmp(Employee emp) {
        String sql = "INSERT INTO employee (emp_id, emp_name, designation, prog_stack, email, password) VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, emp.getEmp_id(), emp.getEmp_name(), emp.getDesignation(), emp.getProgStack(), emp.getEmail(), emp.getPassword());
        return "Employee added successfully!";
    }

    @Override
    public String addEmpBulk(List<Employee> employeeList) {
        String sql = "INSERT INTO employee (emp_id, emp_name, designation, prog_stack, email, password) VALUES (?, ?, ?, ?, ?, ?)";
        for (Employee emp : employeeList) {
            jdbcTemplate.update(sql, emp.getEmp_id(), emp.getEmp_name(), emp.getDesignation(), emp.getProgStack(), emp.getEmail(), emp.getPassword());
        }
        return "Bulk employees added successfully!";
    }

    @Override
    public List<Employee> getEmp() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, rowMapper);
    }

    @Override
    public Employee getEmpById(long empid) {
        String sql = "SELECT * FROM employee WHERE emp_id = ?";
        List<Employee> employees = jdbcTemplate.query(sql, rowMapper, empid);
        return employees.isEmpty() ? null : employees.get(0);
    }

    @Override
    public String deleteById(long empid) {
        String sql = "DELETE FROM employee WHERE emp_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, empid);
        if (rowsAffected > 0) {
            return "Employee deleted successfully!";
        } else {
            return "Employee id is not registered with id " + empid + "!!";
        }
    }

    @Override
    public String updateById(long empid) {
        String sql = "UPDATE employee SET email = ? WHERE emp_id = ?";
        int rowsAffected = jdbcTemplate.update(sql, "david@gmail.com", empid);
        if (rowsAffected > 0) {
            return "Employee updated successfully!";
        } else {
            return "Employee not found to update!";
        }
    }
}