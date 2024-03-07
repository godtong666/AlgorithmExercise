package com.godtong.array.p189;

import java.util.Arrays;

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;//防止k比数组的长度更长
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
