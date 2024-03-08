package com.godtong.array.p41;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int firstMissingPositive(int[] nums) {
        //把所有元素都放入set
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        //记录set的大小
        int size = set.size();
        for (int i = 1; true; i++) {
            //从1开始遍历，把元素添加进set
            set.add(i);
            //如果set的大小变化了，i就是答案
            if (set.size() != size){
                return i;
            }
        }
    }
}
