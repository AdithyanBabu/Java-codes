import java.util.Arrays;
import java.util.Scanner;
public class CountingSort {


    static int max(int[] arr){
        int ele = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > ele)
                ele = arr[i];
        }
        return ele;
    }

    static void countingSort(int[] inputArray, int max, int size){
        int[] countArray = new int[max+1];
        for (int i = 0; i < max+1; i++) {
            countArray[i] = 0;
        }

        //giving the frequencies of each element in the input array to the count array
        int count;
        int tmp;
        for (int i = 0; i < size; i++) {
            tmp = inputArray[i];
            count = 0;
            for(int j = 0; j < size; j++)
                if (tmp == inputArray[j]) {
                    count++;
                }
            countArray[tmp] = count;
        }

        //cumulating the sum in the count array
        for (int i = 1; i < max+1; i++) {
            countArray[i] += countArray[i-1];
        }

        //calculating the output array
        int[] outputArray = new int[size];
        for (int i = size-1; i >=0 ; i--) {
            outputArray[countArray[inputArray[i]] - 1] = inputArray[i];
            --countArray[inputArray[i]];
        }
        System.out.println("The sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(outputArray[i]+" ");
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
        int max = max(inputArray);
        countingSort(inputArray,max,size);


    }
}
