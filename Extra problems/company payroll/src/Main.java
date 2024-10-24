import validating.Validation;

import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Employee> employeeArrayList = new ArrayList<>();

    public static void main(String[] args) {
        String empName, id;
        String type;

        System.out.print("Enter the number of employees: ");
        int empNumber = Validation.validNumber(); // to get a valid number
        int count = 0;
        Employee e = null;


        while (count < empNumber) {
            System.out.println("Enter details for Employee " + (++count));

            System.out.print("Enter the employee name: ");
            empName = Validation.validName(); // to get a valid name

            System.out.print("Enter the employee ID: ");
            id = checkID(); // check whether the id is already existing or not

            System.out.print("Enter employee type (1 for Full-Time, 2 for Part-Time): ");
            type = checkType(); // check the type
            if (type.equals("1")) {
                e = new FullTimeEmployee(empName, id); // full-time employee for type 1
            } else {
                e = new PartTimeEmployee(empName, id);// part-time employee for type 2
            }

            employeeArrayList.add(e); // Add employee to the list
            e.salaryCalculation();    // Calculate salary
        }

        // Display details of all employees after salary calculation

        System.out.println("\nEmployee Salary Details:");
        for (Employee emp : employeeArrayList) {
            emp.displayEmployeeDetails();
        }
    }

    /* Checking the type of employee*/
    public static String checkType() {
        String type;
        while (true) {
            type = sc.next();
            if (!type.equals("1") && !type.equals("2")) {
                System.out.println("Invalid input! Please enter 1 for Full time or 2 for Part time: ");
            } else {
                break;
            }
        }
        return type;
    }

    /* Checking whether the ID is already present or not*/
    public static String checkID() {
        String id;
        id = String.valueOf(Validation.validNumber()); // to get a valid number
        for (Employee emp : employeeArrayList) {
            if (emp.getID().equals(id)) {  // getId() returns the employee ID
                System.out.println("This ID already exists, please enter another one");
                id = String.valueOf(Validation.validNumber());
            } else {
                break; // getting a new id
            }
        }
        return id;
    }
}