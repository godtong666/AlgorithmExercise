package com.godtong.slidingwindow.p76;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 错误方法：思路错误
 * 没有考虑到用：
 * if (Objects.equals(window.get(c), need.get(c))) {
 *   valid++;
 * }
 * 用这个就可以匹配到重复字符的数量，字符重复数量相同就为有效
 */
public class Solution {
    public String minWindow(String s, String t) {
        if (s.equals(t)) {
            return t;
        }

        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //left和right是一个左开右闭区间
        int left = 0;
        int right = 0;
        int valid = need.size();
        String minStr = "";

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            //进行窗口内数据的一系列更新..
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
            }

            //System.out.format("window: [%d, %d)\n", left, right);

            while (valid == window.size()) {
                AtomicBoolean flag = new AtomicBoolean(true);
                need.forEach((needKey, needValue) -> {
                    Integer windowValue = window.get(needKey);
                    if (windowValue < needValue) {
                        flag.set(false);
                    }
                });
                if (flag.get()) {
                    char d = s.charAt(left);
                    //找到长度更短的字符串了
                    if ((right - left) <= minStr.length() || minStr.isEmpty()) {
                        minStr = s.substring(left, right);
                    }
                    left++;
                    //进行窗口内数据的一系列更新..
                    Integer i = window.get(d);
                    if (i != null) {
                        window.put(d, --i);
                        if (window.get(d) == 0) {
                            window.remove(d);
                        }
                    }
                }
                //window.computeIfPresent(d, (k, v) -> --v == 0 ? window.remove(d) : v);
                //System.out.format("window: [%d, %d)\n", left, right);
            }
        }
        return minStr;
    }
}
