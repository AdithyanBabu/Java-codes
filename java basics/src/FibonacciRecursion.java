import java.util.Scanner;

public class FibonacciRecursion {

    //fibonacci using recursion
    public static int fibonacci(int fib) {
        if(fib <= 1)
            return fib;
        return fibonacci(fib - 1) + fibonacci(fib - 2);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a limit");
        int fib = sc.nextInt();
        for (int i = 0; i < fib; i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }
}
