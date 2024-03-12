package com.godtong.matrix.p240;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            int search = search(ints, target);
            if (search >= 0) {
                return true;
            }
        }
        return false;
    }

    public int search(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int num = arr[mid];
            if (num == target) {
                return mid;
            }
            else if (num < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
