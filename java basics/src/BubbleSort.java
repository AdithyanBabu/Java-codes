import java.util.Scanner;

public class BubbleSort {
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

    static void bubbleSort(){
        int tmp;
        for(int i=0; i<count-1; i++){
            for(int j=0; j<count-i-1; j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
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
        bubbleSort();
        print();
    }
}
