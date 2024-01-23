package com.godtong.p560;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * <p>
 * 子数组的长度不固定，所以不能用双指针
 * <p>
 * num小于k时，右指针右移。num大于k，左指针左移。
 * <p>
 * 我这个思路错误！遇到负数就不行了
 */
public class Solution {
    public int subarraySum(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int arrayNums = 0;

        if (nums.length == 1 && k == 0) {
            return 0;
        }

        for (; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                arrayNums++;
            }
        }
        return arrayNums;
    }
}
