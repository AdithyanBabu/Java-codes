import java.util.Scanner;

public class DecToBinViceVersa {

    public static void binary(int num){
        int[] arr = new int[1000];
        int i = 0;
        while (num > 0){
            arr[i] = num%2;
            i++;
            num = num/2;
        }
        arr[i] = '\0';
        System.out.println("The Binary element is");
        for (int j = i-1; j >= 0; j--) {
            System.out.print(arr[j]);
        }
    }
    public static void decimal(int num1){
        int r, tmp = 0,n = 0;
        while(num1>0){
            r = num1%10;
            tmp = tmp + r*(int) Math.pow(2,n);
            num1 /= 10;
            n++;
        }
        System.out.println("The Decimal No is: "+tmp);
    }
    public static void main(String[] args) {
        int num;
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Decimal to binary\n2. Binary to decimal");
        num = sc.nextInt();
        int n;
        String st;
        switch (num){
            case 1:
                System.out.println("Enter a decimal number");
                n = sc.nextInt();
                binary(n);
                break;
            case 2:
                System.out.println("\nEnter a binary number");
                st = sc.next();
                int n1 = Integer.parseInt(st);
                decimal(n1);
                break;
            default:
                System.out.println("Invalid");
                break;
        }


    }
}
