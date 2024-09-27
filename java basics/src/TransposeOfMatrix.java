import java.util.Scanner;

public class TransposeOfMatrix {
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
        //transposing the matrix
        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}