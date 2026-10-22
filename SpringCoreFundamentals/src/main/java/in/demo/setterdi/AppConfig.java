package in.demo.setterdi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Noida, Uttar Pradesh");
    }

    @Bean
    public Employee employee(Address address) {
        Employee emp = new Employee();
        emp.setId(101);
        emp.setName("Shivansh");
        emp.setAddress(address); // Setter Injection
        return emp;
    }
}