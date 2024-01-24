package com.godtong.p239;

import java.util.ArrayList;
import java.util.List;

/**
 * 利用队列，
 * <p>
 * 队列的长度 < k时,enqueue，判断大小。
 * <p>
 * 队列的长度 > k时,dequeue，判断大小。如果出队的是max会影响下一次判断的结果。如果出队的是max，max改为第二大的结果。
 * <p>
 * 先出队，后入队
 * <p>
 * 错误！测试未通过
 */
public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        List<Integer> maxList = new ArrayList<>();

        if (k == 1) {
            return nums;
        }

        //先把队列弄到k
        for (; right < k; right++) {
            if (nums[right] > max) {
                max = nums[right];
            }
            else {
                if (nums[right] > sec) {
                    sec = nums[right];
                }
            }
        }
        maxList.add(max);

        //先出队，后入队，边做变判断
        while (right < nums.length) {
            if (nums[left] >= max) {
                max = sec;
                if (max == sec) {
                    sec = Integer.MIN_VALUE;
                }
            }
            left++;

            if (nums[right] > max) {
                max = nums[right];
            }
            else {
                if (nums[right] > sec) {
                    sec = nums[right];
                }
            }
            right++;

            if (right - left == k) {
                maxList.add(max);
            }
        }
        return maxList.stream().mapToInt(Integer::intValue).toArray();
    }
}
