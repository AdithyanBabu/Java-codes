import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number");
        int prime = sc.nextInt();
        boolean flag = true;
        if(prime <= 1)
            System.out.println(prime + " is neither prime nor composite number");
        else {
            for (int i = 2; i < prime/2; i++) {
                if (prime % i == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                System.out.println(prime + " is a prime number");
            else
                System.out.println(prime + " is not a prime number");
        }
    }
}
