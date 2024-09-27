import java.util.Scanner;

public class P15 {
    public static void main(String[] args) {
        int n;
        System.out.println("Enter the size of the array: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        System.out.println("Enter the elements: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int big = arr[0];
        int small = arr[0];
        for (int i = 0; i < n; i++) {
            if (arr[i] > big)
                big = arr[i];
            if(arr[i] < small)
                small = arr[i];
        }
        System.out.println("Largest no: "+big);
        System.out.println("Smallest no: "+small);
    }
}
