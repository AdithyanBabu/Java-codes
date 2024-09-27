import java.util.Scanner;

public class QuickSort {
    static int partition(int[] arr, int low, int high){
        //initializing the pivot as the last element in the array
        int pi = arr[high];
        int i = low - 1;
        int tmp;

        //elements less than pivot will be placed left side of the array
        for (int j = low; j < high; j++) {
            if(arr[j] < pi){
                i++;
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
        }

        //Placing the pivot in correct position
        tmp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = tmp;
        return i+1;
    }

    static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
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
        quickSort(inputArray,0,size-1);
        System.out.println("The sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(inputArray[i]+" ");
        }

    }
}
