import java.util.Scanner;

public class SelectionSort {

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
    }
    static void selectionSort(){
        int min;
        int tmp;
        for (int i = 0; i < count; i++) {
            min = i;
            for (int j = i+1; j < count; j++) {
                if(arr[min] > arr[j]){
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
    static void print(){
        System.out.println("The sorted array is");
        for (int i = 0; i < count; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        read();
        selectionSort();
        print();
    }
}
