import java.util.Scanner;

public class P2 {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter your limit");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i<= n; i++) {
            if(i%2 == 0)
                System.out.println(i);
        }
    }
}
