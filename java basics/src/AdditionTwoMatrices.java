import java.util.Scanner;

public class AdditionTwoMatrices {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no:of rows and columns");
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] mat1 = new int[row][col];
        int[][] mat2 = new int[row][col];
        //Initializing the value of 2 matrixes
        System.out.println("Enter first Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat1[i][j] = sc.nextInt();
            }
        }
        System.out.println("Enter second Matrix");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat2[i][j] = sc.nextInt();
            }
        }
        //Addition of 2 arrays
        int[][] mat3 = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                mat3[i][j] = mat1[i][j]+mat2[i][j];
            }
        }
        System.out.println("The added array is:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat3[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
