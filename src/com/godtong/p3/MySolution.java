package com.godtong.p3;

import java.util.HashSet;
import java.util.Set;

public class MySolution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        Set<Character> maxSet = null;
        char[] charArray = s.toCharArray();
        int maxStrLength = 0;

        int l = 0;
        int r = 0;
        int lMax = 0;
        int rMax = 0;
        for (char c : charArray) {
            if (!set.contains(c)) {
                if ((r - l + 1) >= maxStrLength) {
                    maxStrLength = r - l + 1;
                    lMax = l;
                    rMax = r;
                    maxSet = new HashSet<>(set);
                }
                set.add(c);
            }
            else {
                if ((r - l) >= maxStrLength) {
                    maxStrLength = r - l;
                    lMax = l;
                    rMax = r;
                    maxSet = new HashSet<>(set);
                }
                set.clear();
                set.add(c);
                l = r;
            }
            r++;
        }
        for (lMax = lMax - 1; lMax >= 0; lMax--) {
            if (!maxSet.contains(charArray[lMax])) {
                if ((rMax - lMax) >= maxStrLength) {
                    maxStrLength = rMax - lMax + 1;
                }
                maxSet.add(charArray[lMax]);
            }
            else {
                break;
            }
        }
        return maxStrLength;
    }
}
