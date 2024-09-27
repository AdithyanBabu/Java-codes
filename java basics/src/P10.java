import java.util.Scanner;

public class P10 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        n = sc.nextInt();
        if (n%400 == 0)
            System.out.println(n+" a leap year");
        else if (n%100 !=0 && n%4 == 0)
            System.out.println(n+" a leap year");
        else
            System.out.println("Not a Leap year");
    }
}
