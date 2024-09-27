import java.util.Scanner;

import static java.lang.String.*;

public class AcromaticString {
    public static void acromatic(String str){
        for (int i = 0; i < str.length(); i++) {
            if(i == 0)
                System.out.print(str.charAt(i));
            else if (str.charAt(i) == ' ')
                System.out.print(str.charAt(i+1));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        acromatic(str);
    }
}
