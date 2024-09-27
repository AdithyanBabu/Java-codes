import java.util.Scanner;

public class SoritngMatrix {
    public static void bubbleSort(int[][] array,int row1, int col1){
        int tmp;
        int size = row1*col1;
        //for ith element arr[j/col][j%col]:- j = i-1 can be used
        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < size-i-1; j++) {
                if(array[j/ col1][j% col1] > array[(j+1)/ col1][(j+1)% col1]){
                    tmp = array[j/ col1][j% col1];
                    array[j/ col1][j% col1] = array[(j+1)/ col1][(j+1)% col1];
                    array[(j+1)/ col1][(j+1)% col1] = tmp;
                }
            }
        }
    }
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
        bubbleSort(mat,row,col);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
