import java.util.Scanner;
import java.lang.*;

public class ArmstrongNumber {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Following are the armstrong no: ");
        for(int i = 1; i<1000; i++) {
            if (isArmstrong(i))
                System.out.print(i + " ");
        }
    }

    static boolean isArmstrong(int num){
        int tmp = num;
        int s = 0, r = 0, digit = 0;
        while(num>0){
            num /= 10;
            digit++;
        }
        num = tmp;
        while (num > 0) {
            r = num%10;
            s += (int) Math.pow(r,digit);
            num /= 10;
        }
        return s == tmp;
    }
}







