package com.godtong.p11;

public class Solution {
    public int maxArea(int[] height) {
        //硬性要求：i<j
        int i = 0; //左指针，只能++
        int j = height.length - 1; //右指针，只能--
        int area = 0;
        int maxArea = 0;
        //面经公式:小高*(j-i)
        //只需要移动小高的指针，因为大高的情况可以排除
        while (i < j) {
            if (height[i] < height[j]) {
                area = height[i] * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
                i++;
            }
            else {
                area = height[j] * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
                j--;
            }
        }
        return maxArea;
    }
}
