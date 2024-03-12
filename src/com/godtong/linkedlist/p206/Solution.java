package com.godtong.linkedlist.p206;

import com.godtong.linkedlist.ListNode;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode node = head;
        ListNode preNode = null;
        ListNode nextNode;
        while (node != null) {
            nextNode = node.next;
            node.next = preNode;
            preNode = node;
            node = nextNode;
        }
        return preNode;
    }
}
