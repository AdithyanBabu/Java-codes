import java.util.Scanner;

public class WordOperations {


    public static void wordOperations(String paragraph) {
        String[] wordArray = paragraph.split(" ");

        //The Word Count
        System.out.println("The no:of words are: " + wordArray.length);

        //Sorting the String array
        for (int i = 0; i < wordArray.length; i++) {
            String temp;
            for (int j = 0; j < wordArray.length-i-1; j++) {
                if (wordArray[j].length() > wordArray[j+1].length()) {
                    temp = wordArray[j];
                    wordArray[j] = wordArray[j+1];
                    wordArray[j+1] = temp;
                }
            }
        }


        //Larger Strings
        int largeCount = wordArray[wordArray.length-1].length(); // to find more than one large strings

        System.out.print("Largest words: ");
        int secondLargeCount = 0;
        for (int i = wordArray.length-1; i >= 0; i--) {
            if(wordArray[i].length() == largeCount){
                System.out.print(wordArray[i]+" ");
            }
            else{
                secondLargeCount = wordArray[i].length();
                break;
            }
        }
        //Second-Largest element in the array
        System.out.print("\nSecond largest words: ");
        for (int i = 0; i < wordArray.length; i++) {
            if(wordArray[i].length() == secondLargeCount){
                System.out.print(wordArray[i]+" ");
            }
        }


        System.out.print("\nSmallest words: ");
        int secondSmallestCount = 0;
        for (int i = 0; i < wordArray.length; i++) {
            if(wordArray[i].length() == wordArray[0].length()){
                System.out.print(wordArray[i]+" ");
            }
            else{
                secondSmallestCount = wordArray[i].length();
                break;
            }
        }

        //Second-Smallest element in the array
        System.out.print("\nSecond Smallest words: ");
        for (int i = 0; i < wordArray.length; i++) {
            if(wordArray[i].length() == secondSmallestCount){
                System.out.print(wordArray[i]+" ");
            }
        }


    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the paragraph: ");
        String paragraph = s.nextLine();
        //calling funciton
        wordOperations(paragraph);

    }
}

