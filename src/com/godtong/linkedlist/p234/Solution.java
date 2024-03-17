package com.godtong.linkedlist.p234;

import com.godtong.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 模拟栈的实现
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode p = head;
        int size = 0;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
            size++;
        }

        p = head;
        for (int i = 1; i <= size / 2; i++) {
            Integer val = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            if (val != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
    }
}
