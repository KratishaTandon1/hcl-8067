package Module1.Task;

class Employee {
    public String name;
    public int id;
    public double salary;

    Employee(String s,int i,double sal){
        name=s;
        id=i;
        salary=sal;
    }

    @Override
    public String toString() {
        return "Employee[ID=" + id + ", Name=" + name + ", Salary=" + salary + "]";
    }
}

