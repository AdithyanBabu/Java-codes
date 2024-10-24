import java.util.Objects;
import java.util.Scanner;

class Employees {
    String empName;
    int age;
    String designation;
    double salary;

    /*Constructor to store the details of each item to the respective variables*/
    Employees(String itemName, int quantity, String designation, double price) {
        this.empName = itemName;
        this.age = quantity;
        this.designation = designation;
        this.salary = price;
    }

    /*function to display the item details*/
    public void display() {
        System.out.printf("%-15s %-10d %-15s %-15.2f%n", empName, age, designation, salary);
    }
}

public class EmployeesDetails {

    /* To validate the name */
    static String validName() {
        Scanner sc = new Scanner(System.in);
        String name = "";
        boolean isValid = true; // To validate the name string
        while (isValid) {
            System.out.print("Employee Name : ");
            name = sc.nextLine();
            isValid = !(name.matches("[a-zA-Z\\s]+") && !name.isEmpty());
            if (isValid) {
                System.out.println("Enter a valid" +
                        " name");
            }
        }
        return name;
    }

    /* Method to get validated quantity */
    public static int getAge() {
        int age = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Age : ");
            if (sc.hasNextInt()) {
                age = sc.nextInt();
                if (age <= 15 && age > 70) {
                    System.out.println("Age must be greater than 15 and lesser than 70. Please re-enter.");
                } else {
                    sc.nextLine();  // Consume the newline character
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter an integer for age.");
                sc.next(); // Clear the invalid input
            }
        }
        return age; // Return the validated quantity
    }

    /* Method to get validated price*/
    public static double getSalary() {
        double salary = 0.0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Salary: ");
            if (sc.hasNextDouble()) {
                salary = sc.nextDouble();
                if (salary <= 0) {
                    System.out.println("Salary must be greater than 0. Please re-enter.");
                } else {
                    sc.nextLine();
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a decimal number for salary.");
                sc.next(); // Clear the invalid input
            }
        }
        return salary; // Return the validated price
    }

    public static String getDesignation() {
        Scanner sc = new Scanner(System.in);
        boolean isDesignation = true;
        String designation = "";
        while (isDesignation){
            System.out.println("Designation (Trainee, Associate or Lead) : ");
            designation = sc.nextLine();
            if(Objects.equals(designation, "Trainee") || Objects.equals(designation, "Associate Engineer") ||
                    Objects.equals(designation, "Lead")) {
                isDesignation = false;
            } else {
                System.out.println("Enter the given designation");
            }
        }
        return designation;
    }

    /* main function */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no:of employees");
        int empNumber = sc.nextInt();

        /*Initialising the item data*/
        String empName;
        int age;
        String designation;
        double salary;

        Employees[] employee = new Employees[empNumber]; // Creating the array of objects to store each
        // instance of the items

        System.out.println("Enter the details of each employee"); //Taking the details of each item
        for (int i = 0; i < empNumber; i++) {
            System.out.println("\nEnter the " + (i + 1) + " employee details");
            empName = validName();

            age = getAge();

            designation = getDesignation();

            salary = getSalary();

            employee[i] = new Employees(empName, age, designation, salary); //Storing the details in the array
        }

        System.out.println("Enter the designation to search");
        String search = sc.next();
        for (int i = 0; i < empNumber; i++) {
            if(employee[i].designation.equals(search)){
                employee[i].display();
            }
        }
    }
}
