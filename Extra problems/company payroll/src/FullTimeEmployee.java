import validating.Validation;

public class FullTimeEmployee extends Employee{


    FullTimeEmployee(String name, String id){
        super(name, id);
    }

    @Override
    public void salaryCalculation() { // abstract method definition for type 1 employee
        System.out.print("Enter monthly salary: ");
        salary = Validation.validDouble();//to check for the double ds

    }

}
