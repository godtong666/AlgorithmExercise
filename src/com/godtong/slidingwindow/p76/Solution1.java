package com.godtong.slidingwindow.p76;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public class Solution1 {
    public String minWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //left和right是一个左开右闭区间
        int left = 0;
        int right = 0;
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;
            //进行窗口内数据的一系列更新..
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(window.get(c), need.get(c))) {
                    valid++;
                }
            }

            while (valid == need.size()) {
                //找到长度更短的字符串了
                if ((right - left) < len) {
                    start = left;
                    len = right - left;
                }

                //d 是将移出窗口的字符
                char d = s.charAt(left);
                // 左移窗口
                left++;
                //进行窗口内数据的一系列更新..
                if (need.containsKey(d)) {
                    if (Objects.equals(window.get(d), need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
