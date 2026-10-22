package in.demo.hrms;

import in.demo.hrms.SalaryPack.BasicSalary;
import in.demo.hrms.SalaryPack.DaSalary;
import in.demo.hrms.SalaryPack.HrSalary;
import in.demo.hrms.SalaryPack.Salary;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public Employee employee(Address address, Department department, Salary salary) {
        return new Employee("Shivansh",  address, department, salary);
    }

    @Bean
    public Address address() {
        return new Address("Crossing Republic");
    }

    @Bean
    public Department department() {
        return new Department("HR");
    }

    @Bean
    public BasicSalary basicSalary() {
        return new BasicSalary(100000);
    }

    @Bean
    public HrSalary hrSalary() {
        return new HrSalary(10000);
    }

    @Bean
    public DaSalary daSalary() {
        return new DaSalary(40000);
    }

    @Bean
    public Salary salary(BasicSalary basicSalary, HrSalary hrSalary, DaSalary daSalary) {
        return new Salary(basicSalary, hrSalary, daSalary);
    }
}