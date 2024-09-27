import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range:");
        n = sc.nextInt();
//        int s = 0;
//        int k = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k <= i ; k++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
