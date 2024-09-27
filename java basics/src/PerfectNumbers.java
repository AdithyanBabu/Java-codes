import java.util.Scanner;

public class PerfectNumbers {
    public static void main(String[] args) {
        int limit;
        System.out.println("Enter your limit");
        Scanner sc = new Scanner(System.in);
        limit = sc.nextInt();
        for(int i=1; i<limit; i++) {
            if (isPerfect(i))
                System.out.println(i + " is a perfect number");
        }
    }

    static boolean isPerfect(int num) {
        int s = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0)
                s += i;
        }
        return s == num;
    }
}
// i/p: 6, 28 perfect numbers