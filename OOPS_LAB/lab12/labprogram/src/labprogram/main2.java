package labprogram;

import java.util.ArrayList;
import java.util.List;

class GenericStack<T> {
    private List<T> stack;

    public GenericStack() {
        stack = new ArrayList<>();
    }

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return stack.remove(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}

class Student {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student: " + name;
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee: " + name;
    }
}

public class main2 {
    public static void main(String[] args) {
        GenericStack<Student> studentStack = new GenericStack<>();
        studentStack.push(new Student("Alice"));
        studentStack.push(new Student("Bob"));

        while (!studentStack.isEmpty()) {
            Student student = studentStack.pop();
            System.out.println(student);
        }

        GenericStack<Employee> employeeStack = new GenericStack<>();
        employeeStack.push(new Employee("Charlie"));
        employeeStack.push(new Employee("David"));

        while (!employeeStack.isEmpty()) {
            Employee employee = employeeStack.pop();
            System.out.println(employee);
        }
    }
}

