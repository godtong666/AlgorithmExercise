package com.godtong.p42;

/**
 * 按行遍历，计算每行符合条件的雨水量
 * 超出时间限制了
 */
public class Solution {
    public int trap(int[] height) {
        int max = Integer.MIN_VALUE;
        int result = 0;

        for (int i : height) {
            max = Math.max(i, max);
        }
        for (int i = 1; i <= max; i++) {
            boolean isStart = false;
            int tempSum = 0;
            for (int j : height) {
                if (isStart && j < i) {
                    tempSum++;
                }
                if (j >= i) {
                    result += tempSum;
                    tempSum = 0;
                    isStart = true;
                }
            }
        }
        return result;
    }
}