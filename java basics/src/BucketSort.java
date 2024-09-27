import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BucketSort {

    static void bubbleSort(List<Float> bucket){
        float tmp;
        for (int i = 0; i < bucket.size(); i++) {
            for (int j = 0; j < bucket.size()-i-1; j++) {
                if(bucket.get(j) > bucket.get(j+1)){
                    tmp = bucket.get(j);
                    bucket.set(j, bucket.get(j+1));
                    bucket.set(j+1,tmp);
                }
            }
        }
//        for (Float v : bucket) {
//            System.out.print(v+" ");
//        }
    }
    static void bucketSort(float[] arr){
        int length = arr.length;
        List<Float>[] bucket = new ArrayList[length];

        //emptying the arraylist
        for (int i = 0; i < length; i++) {
            bucket[i] = new ArrayList<>();
        }

        //converting each element in the input array as (index = length * array element)and storing it in the proper bucket[index]
        int tmp;
        for (int i = 0; i < length; i++) {
            tmp = (int) (length*arr[i]);
            bucket[tmp].add(arr[i]);
        }

        //sorting the element in each index of the list
        for (int i = 0; i < length; i++) {
            bubbleSort(bucket[i]);
        }


        int i = 0;
        //adding back to the input array
        for(int j = 0; j < length; j++){
            for (int k = 0; k < bucket[j].size(); k++) {
                arr[i++] = bucket[j].get(k);
            }
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the input array:");
        int size = sc.nextInt();
        float[] inputArray = new float[size];
        System.out.println("Enter the input array:");
        for (int i = 0; i < size; i++) {
            inputArray[i] = sc.nextFloat();
        }
        bucketSort(inputArray);
        System.out.println("The sorted array is:");
        for (int i = 0; i < size; i++) {
            System.out.print(inputArray[i]+" ");
        }
    }
}
