package com.godtong.slidingwindow;

import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口算法框架
 */
public class SlidingWindowFramework {
    public void slidingWindow(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            need.getOrDefault(c, 1);
        }

        int left = 0;
        int right = 0;
        //d 变量表示窗口中满足 need 条件的字符个数，如果 valid 和 need.size 的大小相同，则说明窗口已满足条件，已经完全覆盖了串 T。
        int valid = 0;
        while (right < s.length()) {
            //c是将移入窗口的字符
            char c = s.charAt(right);
            // 右移窗口
            right++;

            //进行窗口内数据的一系列更新..


            //debug 输出的位置
            System.out.format("window: [%d, %d)\n", left, right);

            //判断左侧窗口是否要收缩
            /*while (window needs shrink) {
                //d 是将移出窗口的字符
                char d = s.charAt(left);
                //左移窗口
                left++;


                //进行窗口内数据的一系列更新..

            } */
        }
    }
}
