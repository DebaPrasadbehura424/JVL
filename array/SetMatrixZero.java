
// steps first see  mat[i][j] where is 0 present make two array of row and col size then row[i]=true and col[j]=true

// then trvaerse all over the matrix  check if row[i]==true || col[j]==true then set mat[i][j]=0 the  return mat

// another approach also present check in my leetcode

import java.util.Scanner;

public class SetMatrixZero {
    public void execute() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter row size: ");
        int row = sc.nextInt();

        System.out.println("Enter column size: ");
        int col = sc.nextInt();

        int[][] matrix = new int[row][col];

        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        setZeroes(matrix);

        System.out.println("Matrix after setting zeroes:");
        for (int[] r : matrix) {
            for (int val : r) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        sc.close();
    }

    public void setZeroes(int[][] matrix) {
        boolean[] rowZero = new boolean[matrix.length];
        boolean[] colZero = new boolean[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rowZero[i] = true;
                    colZero[j] = true;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rowZero[i] || colZero[j]) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZero sZero = new SetMatrixZero();
        sZero.execute();
    }
}
