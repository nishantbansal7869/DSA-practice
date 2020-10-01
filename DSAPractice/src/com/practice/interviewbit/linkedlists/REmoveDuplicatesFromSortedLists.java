package com.practice.interviewbit.linkedlists;

public class REmoveDuplicatesFromSortedLists {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(1);
        node.next.next = new ListNode(2);
        ListNode ans = removeDupes(node);
    }

    private static ListNode removeDupes(ListNode node) {
        ListNode th = node;
        while (node.next != null){
            if (node.val == node.next.val)
                node.next = node.next.next;
            else
                node = node.next;
        }
        return th;
    }
}
