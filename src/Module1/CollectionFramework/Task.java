package Module1.CollectionFramework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student> {

    int rollNumber;
    String name;
    int age;
    int marks;

    public Student(int rollNumber, String name, int age, int marks) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student other) {
        int byMarks = Integer.compare(other.marks, this.marks);
        if (byMarks != 0) {
            return byMarks;
        }
        return Integer.compare(this.age, other.age);
    }

    @Override
    public String toString() {
        return "Roll " + rollNumber + " | " + name + " | age " + age + " | marks " + marks;
    }
}





public class Task {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        list.add(new Student(1, "A", 21, 82));
        list.add(new Student(2, "B", 19, 74));
        list.add(new Student(3, "C", 21, 82));
        list.add(new Student(4, "D", 20, 90));
        list.add(new Student(5, "E", 19, 58));


        for (Student s : list) {
            System.out.println(s);
        }

        Collections.sort(list);

        System.out.println();
        for (Student s : list) {
            System.out.println(s);
        }
    }


}