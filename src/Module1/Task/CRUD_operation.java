package Module1.Task;
import java.util.*;
public class CRUD_operation {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("A", 1, 75000));
        employees.add(new Employee("B", 2, 50000));
        employees.add(new Employee("C", 3, 90000));
        employees.add(new Employee("D", 4, 65000));

        Iterator<Employee> it=employees.iterator();
        while(it.hasNext()){
            Employee emp=it.next();
            System.out.println(emp.name+ " "+ emp.id+" "+ emp.salary);
        }
        ListIterator<Employee> it1= employees.listIterator();
        while (it1.hasNext()){
            Employee emp=it1.next();
            System.out.println(emp.name+" "+emp.id+" "+emp.salary);
        }

        while(it1.hasPrevious()){
            Employee emp=it1.previous();
            System.out.println(emp.name+" "+emp.id+" "+emp.salary);
        }

        int targetUpdateId = 3;
        for (Employee emp : employees) {
            if (emp.id == targetUpdateId) {
                emp.name = "ABCD";
                emp.salary = 58000;
                System.out.println("Updated record: " + emp);
                break;
            }
        }

        int targetDeleteId = 4;
        Iterator<Employee> deleteIterator = employees.iterator();
        while (deleteIterator.hasNext()) {
            Employee emp = deleteIterator.next();
            if (emp.id == targetDeleteId) {
                deleteIterator.remove();
                break;
            }
        }

        employees.sort(Comparator.comparingDouble(emp -> emp.salary));
        Iterator<Employee> incIterator = employees.iterator();
        while (incIterator.hasNext()) {
            System.out.println(incIterator.next());
        }

        employees.sort((e1, e2) -> Double.compare(e2.salary, e1.salary));

        ListIterator<Employee> decIterator = employees.listIterator();
        while (decIterator.hasNext()) {
            System.out.println(decIterator.next());
        }

    }
}
