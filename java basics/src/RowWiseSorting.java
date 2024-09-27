import java.util.Scanner;

public class RowWiseSorting {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no:of rows and columns");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] mat = new int[row][col];
        //Initializing the value of the matrix
        System.out.println("Enter the Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int tmp, k = 0;
        while(k<row) {
            for (int i = 0; i < col; i++) {
                for (int j = 0; j < col - 1; j++) {
                    if (mat[k][j] > mat[k][j + 1]) {
                        tmp = mat[k][j];
                        mat[k][j] = mat[k][j + 1];
                        mat[k][j + 1] = tmp;
                    }
                }
            }
            k++;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
