package com.godtong.slidingwindow.p438.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution implements com.godtong.slidingwindow.p438.Solution {
    @Override
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (s.isEmpty() && p.isEmpty()) {
            return list;
        }
        Set<Character> set = new HashSet<>();
        int l = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i - l >= p.length()) {

                l++;
            }
            if (p.indexOf(c) == -1) {
                l = i + 1;
                continue;
            }
            set.add(c);
            if (set.size() == p.length()) {
                list.add(l);
                l = i + 1;
            }
        }

        return list;
    }
}
