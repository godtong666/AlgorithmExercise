package com.godtong.array.p56;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2 个区间的关系有以下 6 种，但是其实可以变成上面 3 种情况
 * <p>
 * （只需要假设 第一个区间的起始位置 ≤\leq≤ 第二个区间的起始位置，
 * <p>
 * 如果不满足这个假设，交换这两个区间）。
 * <p>
 * 这 3 种情况的合并的逻辑都很好写。
 * <p>
 * 作者：Sweetiee 🍬
 * 链接：<a href="https://leetcode.cn/problems/merge-intervals/solutions/204805/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/">...</a>
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            }
            else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }
}
