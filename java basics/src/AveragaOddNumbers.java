import java.util.Scanner;

public class AveragaOddNumbers {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter you limit");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        float s = 0;
        int count = 0;
        for (int i = n; i>=1; i--) {
            if(i%2 != 0) {
                s += i;
                count++;
            }
        }
        System.out.println("Average of the odd numbers is : "+s/count);
    }
}
