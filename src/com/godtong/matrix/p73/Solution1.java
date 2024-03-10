package com.godtong.matrix.p73;

public class Solution1 {
    public void setZeroes(int[][] matrix) {
        boolean lineZero = false;
        boolean columnZero = false;
        // 第一列是否有零
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] == 0) {
                columnZero = true;
                break;
            }
        }
        // 第一行是否有零
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                lineZero = true;
                break;
            }
        }
        // 把第一行第一列作为标志位
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        // 置0
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[i].length; j++) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (lineZero) {
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (columnZero) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
