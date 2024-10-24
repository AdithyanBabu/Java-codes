import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.exit;
import validating.Validation;

class Staff{ // inheriting for validation purposes
    Boolean teaching;
    String name;
    String gender;
    String department;
    LocalDate dateOfJoin;
    double salary;
    static ArrayList<Staff> staffList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    Staff(Boolean teaching, String name, String gender, String department,
          LocalDate dateOfJoin, double salary) {
        this.teaching = teaching;
        this.name = name;
        this.gender = gender;
        this.department = department;
        this.dateOfJoin = dateOfJoin;
        this.salary = salary;
    }

    /* Display Staff Details */
    public void displayStaff() {
        System.out.printf("%-15s %-15s %-10s %-15s %-15s %-15s\n", "Teaching", "Name",
                "Gender", "Department", "Date of Join", "Salary");
        for (int i = 0; i < staffList.size(); i++) {
            System.out.printf("%-15s %-15s %-10s %-15s %-15s %-15f\n", staffList.get(i).teaching,
                    staffList.get(i).name, staffList.get(i).gender, staffList.get(i).department,
                    staffList.get(i).dateOfJoin, staffList.get(i).salary);
        }
    }

    /* Add Staff */
    public void addStaff() {


        System.out.println("Teaching or non Teaching(True / False): ");
        boolean teaching = sc.nextBoolean();
        System.out.print("Enter Staff name:");
        String name = Validation.validName();
        System.out.print("Gender: ");
        String gender = Validation.validGender();
        System.out.print("Department: ");
        String department = sc.next();
        System.out.print("date of join: ");
        LocalDate dateOfJoin = Validation.validDob();
        System.out.print("Salary: ");
        double salary = sc.nextDouble();

        Staff staff = new Staff(teaching, name, gender, department, dateOfJoin, salary);
        staffList.add(staff);
    }
}

class Student{ // inheriting for validation purposes
    String name;
    String gender;
    String course;
    LocalDate dateOfJoin;
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);


    Student(String name, String gender, String course, LocalDate dateOfJoin) {
        this.name = name;
        this.gender = gender;
        this.course = course;
        this.dateOfJoin = dateOfJoin;

    }

    /* Add students */
    public void addStudent() {
        System.out.print("Enter student name:");
        String name = Validation.validName();
        System.out.print("Gender: ");
        String gender = Validation.validGender();
        System.out.print("Department: ");
        String course = sc.next();
        System.out.print("date of join: ");
        LocalDate dateOfJoin = Validation.validDob();


        Student student = new Student(name, gender, course, dateOfJoin);
        studentList.add(student);
    }

    /* Display students */
    public void displayStudents() {
        System.out.printf("%-15s %-10s %-15s %-15s\n", "Name", "Gender", "Course", "Date of Join");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.printf("%-15s %-10s %-15s %-15s\n", studentList.get(i).name,
                    studentList.get(i).gender, studentList.get(i).course, studentList.get(i).dateOfJoin);
        }
    }
}


public class StaffStudentDetails {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {


        Student student = new Student("", "", "", null);
        Staff staff = new Staff(null, "", "", "", null, 0);
        while (true) {
            System.out.println("\n1. Add student 2. Add Staff 3. Display student 4. Display student" +
                    " 5. Exit");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    student.addStudent();
                    break;
                case 2:
                    staff.addStaff();
                    break;
                case 3:
                    student.displayStudents();
                    break;
                case 4:
                    staff.displayStaff();
                    break;
                case 5:
                    exit(0);
                default:
                    System.out.println("Invalid Input!");
            }
        }
    }
}