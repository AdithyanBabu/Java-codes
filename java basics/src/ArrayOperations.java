import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static javax.swing.UIManager.get;


public class ArrayOperations {

    static int maxSize = 100;
    static int[] arr = new int[maxSize];
    static int count = 0;


    static void read(){


        System.out.println("Enter integers (press spacebar to stop):");

        Scanner sc = new Scanner(System.in);
        while (count < maxSize) {
            String input = sc.nextLine();

            if (input.trim().isEmpty()) {
                break;
            }
            int number = Integer.parseInt(input);
            arr[count] = number;
            count++;
        }

        sc.close();
        System.out.println("Stopped scanning.");
    }

    static void secondLargest(){
        int largest = arr[0];
        int secondLargest = arr[0];

        for (int i = 0; i < count; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;  // Previous largest becomes second largest
                largest = arr[i];  // Update largest
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];  // Update second largest if it's smaller than largest but larger than the current second largest
            }
        }
        System.out.println("\nThe Second largest element is "+secondLargest);

        int largestCount = 0;
        for (int i = 0; i < count-1; i++) {
            if(largest == arr[i])
                largestCount++;
        }
        System.out.println("The no:of occurrences of the largest element are "+largestCount);
    }


    static void print(){
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    public static void main(String[] args) {

        read();
        print();
        secondLargest();
//        largestOccurrence();
    }

}
