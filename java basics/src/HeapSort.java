import java.util.Scanner;

public class HeapSort {

    public static void heapSort(int[] arr, int n) {
        for (int i = n/2; i >= 0 ; i--) {
            heapify(arr, n, i);
        }

        for (int i = n-1; i > 0 ; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(arr, n, largest);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the input array:");
        int size = sc.nextInt();
        int[] inputArray = new int[size];
        System.out.println("Enter the input array:");
        for (int i = 0; i < size; i++) {
            inputArray[i] = sc.nextInt();
        }
        heapSort(inputArray, size);
        System.out.println("The sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(inputArray[i] + " ");
        }
    }
}