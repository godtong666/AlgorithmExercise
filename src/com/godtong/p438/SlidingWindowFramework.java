package com.godtong.p438;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法框架
 */
public class SlidingWindowFramework {
    public void slidingWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            map.put(c, 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;

            /*
                进行窗口内数据的一系列更新..
             */

            //debug 输出的位置
            System.out.format("window: [%d, %d)\n", left, right);

            //判断左侧窗口是否要收缩
            while (/*window needs shrink*/) {
                //d 是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;

                /*
                    进行窗口内数据的一系列更新..
                */
            }
        }
    }
}
