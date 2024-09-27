import java.util.Scanner;

import static java.lang.System.exit;

public class LinearSearch {
    


    static void linearSearch(int size, int[] arr){
        System.out.println("Enter the item to be searched");
        Scanner sc = new Scanner(System.in);
        int item = sc.nextInt();
        for (int i = 0; i < size; i++) {
            if (item == arr[i]) {
                System.out.println("The item found at " + (i + 1) + "th position");
                exit(0);
            }
        }
        
    }
    public static void main(String[] args) {
//        int maxSize = 100;
//        int[] arr = new int[maxSize];
//        int count = 0;
//
//        System.out.println("Enter integers (press spacebar to stop):");
//
//        Scanner sc = new Scanner(System.in);
//        while (count < maxSize) {
//            String input = sc.nextLine();
//
//            if (input.trim().isEmpty()) {
//                break;
//            }
//            int number = Integer.parseInt(input);
//            arr[count] = number;
//            count++;
//        }
//
//        sc.close();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        linearSearch(size,arr);

    }
}

