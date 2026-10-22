package in.demo.setterdi;

public class Employee {
    private int id;
    private String name;
    private Address address;

    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    // Setter Injection
    public void setAddress(Address address) {
        this.address = address;
    }

    public void display() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
        System.out.println("Address (via Setter DI): " + (address != null ? address.getCity() : "None"));
    }
}