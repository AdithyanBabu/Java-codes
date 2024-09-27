import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;
//input:- animal sequence 0. trivandrum city a bc

public class StartingAddressOfWord {
    public static int find(String para, String word) {

        String[] stringArray = para.split(" ");
        for (String s: stringArray){
            if(s.equals(word)){
                for (int i = 0; i <= para.length() - word.length(); i++) {
                    int j;

                    // Check for the word at position i
                    for (j = 0; j < word.length(); j++) {
                        if (para.charAt(i + j) != word.charAt(j)) {
                            break;  // Mismatch, so break the inner loop
                        }
                    }

                    // If we successfully matched all characters
                    if (j == word.length()) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = sc.nextLine();
        System.out.println("Enter a word to search");
        String word = sc.next();
        System.out.println("length "+ str.length());
        int index = find(str,word);
        if(index != -1)
            System.out.println("Starting Address of the word is: " + index);
        else
            System.out.println("null");
    }
}

