package Module1.Assignment;

import java.util.*;

class Employee {
    int empId;
    String name;
    String role;
    double basic;
    double hra;
    double ta;
    double specialAllowance;

    Employee(int empId, String name, String role,
             double basic, double hra, double ta,
             double specialAllowance) {
        this.empId = empId;
        this.name = name;
        this.role = role;
        this.basic = basic;
        this.hra = hra;
        this.ta = ta;
        this.specialAllowance = specialAllowance;
    }

    double getBonus() {
        double percentage;

        switch (role.toLowerCase()) {
            case "manager":
                percentage = 12;
                break;
            case "admin":
                percentage = 10;
                break;
            case "engineer":
                percentage = 12;
                break;
            case "accountant":
                percentage = 8;
                break;
            default:
                percentage = 0;
        }

        return (basic + hra) * percentage / 100.0;
    }

    void display() {
        System.out.println("------------------------------");
        System.out.println("Emp_id: " + empId);
        System.out.println("Name: " + name);
        System.out.printf("Bonus: Rs. %.2f%n", getBonus());
    }
}

public class Assesment1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String role = sc.nextLine();
            double basic = sc.nextDouble();
            double hra = sc.nextDouble();
            double ta = sc.nextDouble();
            double specialAllowance = sc.nextDouble();

            employees[i] = new Employee(
                    id, name, role, basic, hra, ta, specialAllowance
            );
        }

        Arrays.sort(employees, (a, b) ->
                Double.compare(b.getBonus(), a.getBonus())
        );

        for (Employee employee : employees) {
            employee.display();
        }

        sc.close();
    }
}