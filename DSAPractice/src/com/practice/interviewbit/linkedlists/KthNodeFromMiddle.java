package com.practice.interviewbit.linkedlists;

public class KthNodeFromMiddle {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(14);
        list.next.next = new ListNode(6);
        list.next.next.next = new ListNode(16);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(10);
        int b = 4;
        int ans = kthNode(list, b);
        System.out.println(ans);
    }

    private static int kthNode(ListNode list, int b) {
        int size = getSize(list);
        if (size == 1 && b == 0)
            return list.val;
        size = (size/2)+1;
        b = size - b;
        if (b <= 0)
            return -1;
        while (b > 1){
            list = list.next;
            b--;
        }
        return list.val;
    }

    private static int getSize(ListNode list) {
        int size = 0;
        while (list != null){
            size++;
            list = list.next;
        }
        return size;
    }
}
