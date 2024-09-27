import java.util.Scanner;

public class P9 {
    public static void main(String[] args) {
        int f = 1, n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        n = sc.nextInt();
        System.out.print("The fibonacci series of "+n+" are:\n");
        int a = 0, b = 1;
        int s = 0;
        System.out.print(a+" "+b+" ");
        for (int i = 2; i < n; i++) {
            s = a+b;
            a = b;
            b = s;
            System.out.print(s+" ");
        }
    }
}
