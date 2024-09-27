import java.util.Scanner;

public class DeletionDuplicateEle {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        size = sc.nextInt();
        System.out.println("Enter the elements: ");
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        int[] tmp = new int[size];
        tmp[0] = arr[0];
        int k = 1;
        for(int i = 1; i < size; i++){
            boolean dup = false;
            for (int j = 0; j < k; j++) {
                if(arr[i] == tmp[j]){
                    dup = true;
                    break;
                }
            }
            if(!dup){
                tmp[k] = arr[i];
                k++;
            }
        }
        for (int i = 0; i < k; i++) {
            System.out.print(tmp[i]+" ");
        }
    }
}
