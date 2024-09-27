import java.util.Scanner;

import static java.lang.System.exit;


public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no:of rows and columns of 1st matrix");
        int row1 = sc.nextInt();
        int col1 = sc.nextInt();
        int[][] mat1 = new int[row1][col1];
        //Initializing the value of 1st matrixes
        System.out.println("Enter first Matrix");
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < col1; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter the no:of rows and columns of 2nd matrix");
        int row2 = sc.nextInt();
        int col2 = sc.nextInt();
        int[][] mat2 = new int[row2][col2];
        //Initializing the value of 2nd matrixes
        System.out.println("Enter second Matrix");
        for (int i = 0; i < row2; i++) {
            for (int j = 0; j < col2; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        if (col1 != row2) {
            System.out.println("Cannot do the multiplication");
            exit(0);
        }
        else {
            //Multiplication of 2 arrays
            int[][] mat3 = new int[row1][col2];
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    mat3[i][j] = 0;
                }
            }
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    for (int k = 0; k < row2; k++) {
                        mat3[i][j] = mat3[i][j] + (mat1[i][k] * mat2[k][j]);
                    }
                }
            }

            //printing the resulted array
            for (int i = 0; i < row1; i++) {
                for (int j = 0; j < col2; j++) {
                    System.out.print(mat3[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
