import java.util.Scanner;

public class MergeSort {

    static void merge(int[] arr, int low, int high, int mid){
        int leftSize = mid-low+1;
        int rightSize = high-mid;

        //2 array declaration
        int[] leftArray = new int[leftSize];
        int[] rightArray = new int[rightSize];

        for(int i=0; i<leftSize; i++)
            leftArray[i] = arr[low+i];
        for(int i=0; i<rightSize; i++)
            rightArray[i] = arr[mid+1+i];

        int i = 0;//for left array
        int j = 0;//for right array
        int k = low;//for the main array

        while(i<leftSize && j<rightSize){
            if(leftArray[i] <= rightArray[j]){
                arr[k] = leftArray[i];
                i++;
            }
            else{
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while(i < leftSize){
            arr[k] = leftArray[i];
            i++;
            k++;
        }
        while(j < rightSize){
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    static void partition(int[] arr, int low, int high){
        if(low < high){
            int mid = (low+high)/2;
            partition(arr,low,mid);
            partition(arr,mid+1,high);
            merge(arr,low,high,mid);
        }
    }
    static void print(int[] arr, int size){
        System.out.println("The sorted array is");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size");
        int size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the array elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        partition(arr,0,size-1);
        print(arr,size);
    }
}
