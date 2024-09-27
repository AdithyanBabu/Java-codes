import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TwoArraySameElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of first array");
        int size_1 = sc.nextInt();
        System.out.println("Enter first array");
        String[] array1 = new String[size_1];
        sc.nextLine();
        for (int i = 0; i < size_1; i++) {
            array1[i] = sc.nextLine();
        }


        System.out.println("Enter the size of second array");
        int size_2 = sc.nextInt();
        System.out.println("Enter second array");
        String[] array2 = new String[size_2];
        sc.nextLine();
        for (int i = 0; i < size_2; i++) {
            array2[i] = sc.nextLine();
        }

        if(identical(array1,array2)){
            System.out.println("identical");
        }else {
            System.out.println("not identical");
        }

    }
    static boolean identical(String[] arr1, String[] arr2) {
        Set<String> flag1 = new HashSet<>();
        Set<String> flag2 = new HashSet<>();

        if (arr1.length != arr2.length) {
            return false;
        } else {
            flag1.addAll(Arrays.asList(arr1));
            for (String num : arr2) {
                if (flag1.contains(num))
                    flag2.add(num);
            }
        }
        return flag1.equals(flag2);
    }
}
