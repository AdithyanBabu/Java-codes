import java.util.Arrays;
import java.util.Scanner;

public class RadixSort {

    static int max(int arr[], int n) {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    static void countSort(int[] arr, int n, int exp) {
        int[] outputArray = new int[n]; // output array
        int i;
        int[] countArray = new int[10];

        Arrays.fill(countArray, 0);
        //increments the count of the corresponding digit in the array
        for (i = 0; i < n; i++)
            countArray[(arr[i] / exp) % 10]++;
        //cumulative summing
        for (i = 1; i < 10; i++)
            countArray[i] += countArray[i - 1];

        //output array
        for (i = n - 1; i >= 0; i--) {
            outputArray[countArray[(arr[i] / exp) % 10] - 1] = arr[i];
            countArray[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = outputArray[i];
    }

    static void radixSort(int arr[], int n) {
        int m = max(arr, n);

        for (int exponent = 1; m / exponent > 0; exponent *= 10)
            countSort(arr, n, exponent);
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
        radixSort(inputArray, size);
        System.out.println("The sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(inputArray[i] + " ");
        }
    }
}


