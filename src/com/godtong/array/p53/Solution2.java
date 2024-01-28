package com.godtong.array.p53;

/**
 * 分治法（分解子问题）
 */
public class Solution2 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        return maxSubArraySum(nums, 0, len - 1);
    }

    /**
     * 该方法的作用为划分左右子数组
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private int maxSubArraySum(int[] nums, int left, int right) {
        //递归结束条件
        if (left == right) {
            return nums[left];
        }
        int mid = left + (right - left) / 2;
        //根据当前的left和right，继续划分成左右两个子问题
        //maxCrossingSum根据当前问题的mid，从中间向两边扩散到底选出最大值
        return max3(maxSubArraySum(nums, left, mid),
                maxSubArraySum(nums, mid + 1, right),
                maxCrossingSum(nums, left, mid, right));
    }

    /**
     * 根据当前问题的mid，从中间向两边扩散到底选出最大值
     * @param nums
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int maxCrossingSum(int[] nums, int left, int mid, int right) {
        int sum = 0;
        int leftSumMax = Integer.MIN_VALUE;
        int rightSumMax = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftSumMax) {
                leftSumMax = sum;
            }
        }

        sum = 0;

        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightSumMax) {
                rightSumMax = sum;
            }
        }

        return leftSumMax + rightSumMax;
    }

    /**
     * 求三个数的最大和
     * @param num1
     * @param num2
     * @param num3
     * @return
     */
    private int max3(int num1, int num2, int num3) {
        return Math.max(num1, Math.max(num2, num3));
    }
}
