package in.fielddi;

import org.springframework.stereotype.Component;

@Component
public class Address {
    public String getAddress() {
        return "123 Main St, Anytown, USA";
    }
}