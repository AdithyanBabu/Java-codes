// Mortgage Calculator

import java.sql.SQLOutput;
import java.util.Date;
import java.util.Scanner;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        int p,years;
        double annual;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the Principle Amount: ");
        p = sc.nextInt();
        System.out.print("Enter the Annual Interest Rate: ");
        annual = sc.nextDouble();
        double r = (annual/100)/12;
        System.out.print("Enter the Period in years ");
        years = sc.nextInt();
        int n = years*12;
        double tmp = r+1;
        double po = Math.pow(tmp,n);
        double m = p*(r*po)/(po-1);
        System.out.println("Mortgage:" +m);
    }
}
