package com.practice.interviewbit.linkedlists;

public class ReverseLinkedList2 {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        int m = 2;
        int n = 4;
        ListNode ans = reverse(list, m, n);
    }

    private static ListNode reverse(ListNode list, int m, int n) {
        ListNode th = list;
        ListNode prev;
        while (m > 1){
            th = th.next;
            m--;
        }
        int diff = n - m;
        prev = new ListNode(th.val);
        if (th == list)
            prev = null;
        ListNode temp = null;
        while (diff > 0){
            temp = th.next;
            th.next = prev;
            prev = th;
            th = temp;
            diff--;
        }

        return list;
    }
}
