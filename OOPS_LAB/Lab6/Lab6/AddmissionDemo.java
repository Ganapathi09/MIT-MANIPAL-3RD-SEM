import java.util.Scanner;

class Student {
    int regNumber;
    String name;
    int age;

    public Student(int regNumber, String name, int age) {
        this.regNumber = regNumber;
        this.name = name;
        this.age = age;
    }

    public void display() {
        System.out.println("Registration Number: " + regNumber);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class UGStudent extends Student {
    int semester;
    double fees;

    public UGStudent(int regNumber, String name, int age, int semester, double fees) {
        super(regNumber, name, age);
        this.semester = semester;
        this.fees = fees;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Semester: " + semester);
        System.out.println("Fees: " + fees);
    }
}

class PGStudent extends Student {
    int semester;
    double fees;

    public PGStudent(int regNumber, String name, int age, int semester, double fees) {
        super(regNumber, name, age);
        this.semester = semester;
        this.fees = fees;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("Semester: " + semester);
        System.out.println("Fees: " + fees);
    }
}

public class AdmissionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int totalUGAdmissions = 0;
        int totalPGAdmissions = 0;

        System.out.println("Enter the number of students: ");
        int numStudents = sc.nextInt();

        Student[] students = new Student[numStudents];

        for (int i = 0; i < numStudents; i++) {
            System.out.println("Enter student type (UG/PG): ");
            String studentType = sc.next();

            System.out.println("Enter registration number: ");
            int regNumber = sc.nextInt();
            System.out.println("Enter name: ");
            String name = sc.next();
            System.out.println("Enter age: ");
            int age = sc.nextInt();

            if (studentType.equalsIgnoreCase("UG")) {
                System.out.println("Enter semester: ");
                int semester = sc.nextInt();
                System.out.println("Enter fees: ");
                double fees = sc.nextDouble();
                students[i] = new UGStudent(regNumber, name, age, semester, fees);
                totalUGAdmissions++;
            } else if (studentType.equalsIgnoreCase("PG")) {
                System.out.println("Enter semester: ");
                int semester = sc.nextInt();
                System.out.println("Enter fees: ");
                double fees = sc.nextDouble();
                students[i] = new PGStudent(regNumber, name, age, semester, fees);
                totalPGAdmissions++;
            } else {
                System.out.println("Invalid student type. Enter UG or PG.");
                i--; // Re-enter student details
            }
        }

        System.out.println("\nDetails of UG Students:");
        for (Student student : students) {
            if (student instanceof UGStudent) {
                student.display();
                System.out.println();
            }
        }

        System.out.println("\nDetails of PG Students:");
        for (Student student : students) {
            if (student instanceof PGStudent) {
                student.display();
                System.out.println();
            }
        }

        System.out.println("Total UG Admissions: " + totalUGAdmissions);
        System.out.println("Total PG Admissions: " + totalPGAdmissions);

        sc.close();
    }
}
