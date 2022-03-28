package com.epam.rd.autotasks.matrices;
import java.util.Arrays;

public class TransposeMatrix {
    public static int[][] transpose(int[][] matrix) {
        int[][] B = new int[matrix[0].length][matrix.length];
        int i;
        int j;
        if (matrix[0].length == matrix.length) for (int b = 0; b < matrix.length; b++) B[b][b]=matrix[b][b];
        for (i = 0; i < matrix[0].length; i++)

            for (j = 0; j < matrix.length; j++)

                B[i][j] = matrix[j][i];

        return B;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        int[][] matrix = {
                {1, 2},
                {7, -13}};

        int[][] result = transpose(matrix);
        System.out.println(Arrays.deepToString(result).replace("],", "]\n"));
    }
}
