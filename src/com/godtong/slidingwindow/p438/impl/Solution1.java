package com.godtong.slidingwindow.p438.impl;

import com.godtong.slidingwindow.p438.Solution;

import java.util.*;

public class Solution1 implements Solution {
    @Override
    public List<Integer> findAnagrams(String s, String p) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        List<Integer> result = new ArrayList<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }

            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        //如果窗口中字符d和need的数量相同了，有效数字就要减1了
                        //因为相同说明窗口中的字符d数量即将小于need的数量
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return result;
    }
}
