package com.godtong.mergesimilaritems2363;

import java.util.*;

public class Solution {
    public List<List<Integer>> mergeSimilarItems(int[][] items1, int[][] items2) {
        Map<Integer, Integer> items1Map = new HashMap<>();
        Map<Integer, Integer> items2Map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        //把item2的value放到map里
        for (int i = 0; i < items2.length; i++) {
            items2Map.put(items2[i][0], items2[i][1]);
        }
        //遍历item1
        for (int i = 0; i < items1.length; i++) {
            int item1Key = items1[i][0];
            int item1Value = items1[i][1];
            items1Map.put(item1Key, item1Value);

            List<Integer> numList = new ArrayList<>();
            Integer item2Value;
            //从item2中取元素，如果取不到就为0
            item2Value = items2Map.getOrDefault(item1Key, 0);

            Integer sum = item1Value + item2Value;
            numList.add(item1Key);
            numList.add(sum);
            result.add(numList);
        }
        //遍历item2，防止item2有没添加到numList的情况
        for (int i = 0; i < items2.length; i++) {
            int item2Key = items2[i][0];
            int item2Value = items2[i][1];
            if (!items1Map.containsKey(item2Key)) {
                List<Integer> numList = new ArrayList<>();
                numList.add(item2Key);
                numList.add(item2Value);
                result.add(numList);
            }
        }
        result.sort(new NumComparator());
        return result;
    }
}

class NumComparator implements Comparator<List<Integer>> {
    @Override
    public int compare(List<Integer> o1, List<Integer> o2) {
        if (o1.get(0) > o2.get(0)) {
            return 1;
        }
        else if (o1.get(0) < o2.get(0)) {
            return -1;
        }
        return 0;
    }
}
