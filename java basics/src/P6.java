import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter a number");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int tmp = n;
        int s = 0, r = 0;
        while (n > 0) {
            r = n%10;
            s += r;
            n /= 10;
        }
        System.out.println("The sum of digits: "+s);
    }
}
