import java.util.Scanner;

public class LargestandSmallestInMatrix {
    public static void main(String[] args) {
        int row,col;
        System.out.println("Enter the row and column ");
        Scanner sc = new Scanner(System.in);
        row= sc.nextInt();
        col= sc.nextInt();
        System.out.println("Enter the Matrix ");
        int[][] mat = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int big = mat[0][0];
        int small = mat[0][0];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(mat[i][j] > big)
                    big = mat[i][j];
                if(mat[i][j] < small)
                    small = mat[i][j];
            }
        }
        System.out.println("The largest element is: "+big);
        System.out.println("The smallest element is: "+small);
    }
}
