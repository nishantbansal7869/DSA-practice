package com.practice.interviewbit.linkedlists;


public class PallindromeList {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        //list.next = new ListNode(2);
        //list.next.next = new ListNode(1);
        //list.next.next.next = new ListNode(2);
        //list.next.next.next.next = new ListNode(2);
        //list.next.next.next = new ListNode(1);
        int ans = isPalindorme(list);
        System.out.print(ans);
    }

    private static int isPalindorme(ListNode list) {
        if (list == null)
            return 0;
        int size = getSize(list);
        ListNode mid = findMid(list);
        ListNode sh = mid.next;
        mid.next = null;
        sh = reverse(sh);
        if (size % 2 == 0){
            while (list != null && sh != null){
                if (list.val != sh.val)
                    return 0;
                list = list.next;
                sh = sh.next;
            }
            if (list == null && sh == null)
                return 1;
            return 0;
        }
        else {
            while (list != mid && sh != null){
                if (list.val != sh.val)
                    return 0;
                list = list.next;
                sh = sh.next;
            }
            if (list == mid && sh == null)
                return 1;
            return 0;
            }
    }

    private static ListNode reverse(ListNode sh) {
        if (sh == null || sh.next == null)
            return sh;
        ListNode temp = reverse(sh.next);
        sh.next.next = sh;
        sh.next = null;
        return temp;
    }

    private static int getSize(ListNode list) {
        int size = 0;
        while (list != null){
            size++;
            list = list.next;
        }
        return size;
    }

    private static ListNode findMid(ListNode list) {
        ListNode s = list, f = list;
        while (f.next != null && f.next.next != null){
            s = s.next;
            f = f.next.next;
        }
        return s;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}