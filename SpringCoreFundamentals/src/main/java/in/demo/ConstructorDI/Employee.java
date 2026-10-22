package in.demo.ConstructorDI;


public class Employee {

    private Address address;
    public Employee(Address address) {
        this.address = address;
    }

    public void getAddress() {
        if (address != null) {
            address.getAddress();
        }
    }

    public void getAddress(Address address) {
        if (address != null) {
            address.getAddress();
        } else if (this.address != null) {
            this.address.getAddress();
        }
    }
}