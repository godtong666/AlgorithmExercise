package com.godtong.p3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 这道题主要用到思路是：滑动窗口
 * <p>
 * 什么是滑动窗口？
 * <p>
 * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
 * <p>
 * 如何移动？
 * <p>
 * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
 * <p>
 * 作者：powcai
 * 链接：<a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/solutions/3982/hua-dong-chuang-kou-by-powcai/">...</a>
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty())
            return 0;

        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int left = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                left = Math.max(left, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - left + 1);
        }

        return max;
    }
}
