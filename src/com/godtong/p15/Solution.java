package com.godtong.p15;

import java.util.*;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return res;

        Arrays.sort(nums);
        //如果最小的数都大于0，那么这个数组里的数相加就不会等于0
        if (nums[0] > 0)
            return res;

        for (int i = 0; i < nums.length; i++) {
            //去重，如果i和上一次相同，就没有必要了。因为结果和上一次的相同
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            //定义三个数的指针(i已定义好)
            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    //去重
                    while (l < r && nums[l] == nums[l + 1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r - 1]) {
                        r--;
                    }
                    l++;
                    r--;
                }
                else if (sum < 0) {
                    l++;
                }
                else if (sum > 0) {
                    r--;
                }
            }

        }
        return res;
    }
}
