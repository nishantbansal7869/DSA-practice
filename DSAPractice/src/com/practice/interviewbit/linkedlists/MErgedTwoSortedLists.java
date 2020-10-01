package com.practice.interviewbit.linkedlists;

public class MErgedTwoSortedLists {
    public static void main(String[] args) {
        ListNode a = new ListNode(5);
        a.next = new ListNode(8);
        a.next.next = new ListNode(20);
        ListNode b = new ListNode(4);
        b.next = new ListNode(11);
        b.next.next = new ListNode(15);
        ListNode ans = mergeList(a, b);
    }

    private static ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode th = dummy;
        while (a != null && b != null)
        {
            if (a.val < b.val)
            {
                dummy.next = new ListNode(a.val);
                dummy = dummy.next;
                a = a.next;
            }
            else
            {
                dummy.next = new ListNode(b.val);
                dummy = dummy.next;
                b = b.next;
            }
        }
        if (a != null)
            dummy.next = a;
        else
            dummy.next = b;
        return th.next;
    }
}
