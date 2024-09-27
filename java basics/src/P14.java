import java.util.Scanner;

public class P14 {
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array:");
        size = sc.nextInt();
        int[] arr = new int[size];
        System.out.println("Enter the elements");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < size; i++) {
            int a = arr[i];
            int r, tmp = 0;
            while(a>0){
                r = a%10;
                tmp = (tmp*10)+r;
                a /= 10;
            }
            arr[i] = tmp;
        }
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i]+ " ");
        }
    }

}
