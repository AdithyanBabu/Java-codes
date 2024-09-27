// P1 - largest of 3 numbers


import java.io.*;
import java.util.Scanner;

    public class p1{
        public static void main(String[] args) {
            int a,b,c;
            System.out.println("Enter 3 numbers");
            Scanner scanner = new Scanner(System.in);
            a = scanner.nextInt();
            b = scanner.nextInt();
            c = scanner.nextInt();
            if(a>b){
                if(a>c)
                    System.out.println(a+" is the largest");
                else
                    System.out.println(c+" is the largest");
            }else if(b>c)
                System.out.println(b+" is the largest");
            else
                System.out.println(c+" is the largest");
        }
    }