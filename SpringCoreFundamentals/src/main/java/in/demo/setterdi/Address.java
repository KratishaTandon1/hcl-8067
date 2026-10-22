package in.demo.setterdi;

public class Address {
    private String city;

    public Address() {
        this.city = "Delhi NCR";
    }

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" + "city='" + city + '\'' + '}';
    }
}