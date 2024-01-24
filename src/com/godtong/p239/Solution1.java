package com.godtong.p239;

import java.util.PriorityQueue;

/**
 * 利用大根堆
 * 可以在优先队列中存储二元组 (num,index),表示元素 num在数组中的下标为 index。
 */
public class Solution1 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> queue = new PriorityQueue<>((pair1, pair2) ->
                //自定义排序规则，如果num相同，就按index排序
                pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1]);

        //先初始化堆
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }

        //初始化result为窗口大小（一个窗口一个最大值）
        int[] result = new int[n - k + 1];
        result[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            //先入堆
            queue.offer(new int[]{nums[i], i});
            //再出堆：检查当前堆最大值的index是否在窗口外。如果在窗口外进行出堆操作，然后重复进行此过程
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            //操作堆完成后，读取最大值
            result[i - k + 1] = queue.peek()[0];
        }

        return result;
    }
}
