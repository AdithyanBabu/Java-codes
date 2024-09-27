import java.util.Arrays;
import java.util.Scanner;

public class StringSorting {

    static void stringSort(String str){//function to perform the String sorting
        // Storing it into a String array
        String[] arr = str.split(" ");


        //sorting each element in the array
        for (int i = 0; i < arr.length; i++) {
            char[] charArray = arr[i].toCharArray();
            Arrays.sort(charArray);
            arr[i] = String.valueOf(charArray);
        }

        //sorting the array
        Arrays.sort(arr);

        //printing the elements in the array
        for(String s : arr)
            System.out.println(s);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String");
        String str = sc.nextLine();
        stringSort(str);
    }
}
