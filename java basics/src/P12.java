import java.sql.SQLOutput;
import java.util.Scanner;

public class P12 {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int tmp = n;
        int s, r = 0;
        if(n > 9) {
            do {
                s = 0;
                while (n > 0) {
                    r = n % 10;
                    s += r;
                    n /= 10;
                }
                n = s;
            } while (s > 9);
            System.out.println(s);
        }
        else
            System.out.println(n);
    }
}
