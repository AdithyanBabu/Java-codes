import java.util.Scanner;

public class P8 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the range:");
        n = sc.nextInt();
        int s = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(++s+"\t");
            }
            System.out.println();
        }
    }
}
