package com.godtong.p239;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 利用单调递减队列
 */
public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //队列存储的为下标：i的值
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            //判断当前元素的值是否大于队尾的元素，大于队尾出队再循环判断。直到队列为单调递减，或者队列为空
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //当前元素入队
            deque.offerLast(i);
        }

        //n - k + 1为窗口大小
        int[] result = new int[n - k + 1];
        result[0] = nums[deque.peekFirst()];
        for (int i = k; i < n; i++) {
            //判断当前元素的值是否大于队尾的元素，大于队尾出队再循环判断。直到队列为单调递减，或者队列为空
            while (!deque.isEmpty() && nums[i] >= nums[deque.peekLast()]) {
                deque.pollLast();
            }
            //当前元素入队
            deque.offerLast(i);
            //非窗口内的最大值，需要出队
            while (deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
            result[i - k + 1] = nums[deque.peekFirst()];
        }
        return result;
    }
}
