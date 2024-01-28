package com.godtong.array.p53;

/**
 * 动态规划（优化版）
 */
public class Solution1 {
    public int maxSubArray(int[] nums) {
        int pre = 0;
        int result = nums[0];
        for (int num : nums) {
            pre = Math.max(pre + num, num);
            result = Math.max(pre, result);
        }
        return result;
    }
}
