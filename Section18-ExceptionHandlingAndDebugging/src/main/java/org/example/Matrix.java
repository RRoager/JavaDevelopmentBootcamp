package org.example;

import java.util.Arrays;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix = { //matrix means 2d array
             {0, 0, 0},
             {0, 0, 0},
             {0, 0, 0}
        };

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[j][i] = i;
            }
        }
        printMatrix(matrix);
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }
    }
}
