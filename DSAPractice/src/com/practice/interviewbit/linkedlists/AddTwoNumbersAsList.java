package com.practice.interviewbit.linkedlists;

public class AddTwoNumbersAsList {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        //.next = new ListNode(4);
        //a.next.next = new ListNode(3);
        ListNode b = new ListNode(9);
        b.next = new ListNode(9);
        b.next.next = new ListNode(1);
        ListNode ans = add(a, b);
    }

    private static ListNode add(ListNode a, ListNode b) {
        int sizeA = size(a);
        int sizeB = size(b);
        if (sizeA > sizeB){
            ListNode temp = b;
            int c = sizeA - sizeB;
            ListNode h = temp;
            while (c > 0){
                temp.next = new ListNode(0);
                temp = temp.next;
                c--;
            }
            b = h;
        }
        else {
            ListNode temp = a;
            int c = sizeB - sizeA;
            ListNode h = temp;
            while (c > 0){
                temp.next = new ListNode(0);
                temp = temp.next;
                c--;
            }
            a = h;
        }
        a = reverse(a);
        b = reverse(b);
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode th = dummy;
        while (a != null && b != null){
            int sum = carry + a.val + b.val;
            int n = sum%10;
            carry = sum/10;
            dummy.next = new ListNode(n);
            dummy = dummy.next;
            a = a.next;
            b = b.next;
        }
        if (carry > 0)
            dummy.next = new ListNode(carry);
        dummy = th;
        while (dummy != null && dummy.val == 0)
            dummy = dummy.next;
        return dummy;
    }

    private static int size(ListNode b) {
        int size = 0;
        while (b != null)
        {
            size++;
            b = b.next;
        }
        return size;
    }

    private static ListNode reverse(ListNode a) {
        if (a == null || a.next == null)
            return a;
        ListNode temp = reverse(a.next);
        a.next.next = a;
        a.next = null;
        return temp;
    }
}
