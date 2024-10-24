import java.util.Scanner;

abstract class Employee {
    static Scanner sc = new Scanner(System.in);
    String name;
    String id;
    double salary;

    Employee(String name, String id){
        this.name = name;
        this.id = id;
    }

    public abstract void salaryCalculation(); // to calculate the salary for each type of employee

    public void displayEmployeeDetails() { // to display the details of the employee
        System.out.println("Employee Name: " + name + ", Employee ID: " + id + ", Salary: $" + salary);
    }

    public String getID(){ // to return id for checking the existence
        return id;
    }
}
