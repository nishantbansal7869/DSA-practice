package com.practice.interviewbit.linkedlists;

public class RotateList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        int k = 29;
        ListNode node = rotateList(list, k);
        System.out.print(node.val);
    }

    private static ListNode rotateList(ListNode list, int k) {
        ListNode th = list;

        int size = getSize(list);
        k = k%size;
        if (k == 0)
            return list;
        k = size - k;
        ListNode prev = null;
        ListNode sh = list;
        ListNode tail = list;

        while (tail.next != null)
            tail = tail.next;

        while (k > 0){
            prev = sh;
            sh = sh.next;
            k--;
        }
        if (prev != null)
            prev.next = null;

        tail.next = th;
        list = sh;
        return list;
    }

    private static int getSize(ListNode list) {
        int size = 0;
        while (list != null)
        {
            size++;
            list = list.next;
        }
        return size;
    }
}
