import validating.Validation;

public class PartTimeEmployee extends Employee{

    double hourlyWage, hourWorked;

    PartTimeEmployee(String name, String id){
        super(name, id);
    }

    public void salaryCalculation() {// abstract method definition for type 2 employee
        System.out.print("Enter hourly wage: ");
        hourlyWage = Validation.validDouble();//to check for the double ds`

        System.out.print("Enter hours worked: ");
        hourWorked = Validation.validDouble();//to check for the double ds

        salary = hourlyWage * hourWorked; // calculating the salary for part-time employee
    }

}
