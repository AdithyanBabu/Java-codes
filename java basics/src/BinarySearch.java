import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static void binarySearch(int size, int[] arr){
        Arrays.sort(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the item to be searched");
        int item = sc.nextInt();
        int low = 0;
        int high = size-1;
        int mid = (low+high)/2;

        while(low <= high){
            mid = (low+high)/2;
            if(arr[mid] == item){
                System.out.println("The item found");
                break;
            }
            else if (item < arr[mid])
                high = mid-1;
            else
                low = mid+1;
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
        binarySearch(size,arr);
    }
}
