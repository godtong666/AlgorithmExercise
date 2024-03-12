package com.godtong.linkedlist.p206;

import com.godtong.linkedlist.ListNode;

/**
 * 递归
 */
class Solution1 {
    public ListNode reverseList(ListNode head) {
        return iterator(head, null);
    }

    public ListNode iterator(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }
        ListNode node = iterator(cur.next, cur);
        cur.next = pre;
        return node;
    }
}
