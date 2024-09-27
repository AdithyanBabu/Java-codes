import java.util.Scanner;

public class PalindromeString {
    public static boolean isPalindrome(String str) {
        int length = str.length();
        int count = 0;
        for (int i = 0; i < length/2; i++) {
            if(str.charAt(i) == str.charAt(length-1-i)){
                count++;
            }
        }
        return count == length / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        if(isPalindrome(str))
            System.out.println(str + " is a palindrome");
        else
            System.out.println(str + " is not a palindrome");
    }
}
