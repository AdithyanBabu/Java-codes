import java.util.Scanner;

public class ShellSort {
    static void shellSort(int[] arr) {
        int size = arr.length;

        for (int gap = size / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < size; i += 1) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }

                arr[j] = temp;
            }
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the input array:");
        int size = sc.nextInt();
        int[] inputArray = new int[size];
        System.out.println("Enter the input array:");
        for (int i = 0; i < size; i++) {
            inputArray[i] = sc.nextInt();
        }
        shellSort(inputArray);
        System.out.println("The sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(inputArray[i] + " ");
        }
    }
}


