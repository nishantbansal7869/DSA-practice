package com.practice.interviewbit.linkedlists;

public class ReorderLists {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
      //  list.next.next.next = new ListNode(4);
        ListNode ans = reorderList(list);
        System.out.println(ans.val);
    }

    private static ListNode reorderList(ListNode list) {
        ListNode mid = findMid(list);
        ListNode sh = mid.next;
        mid.next = null;
        sh = reverse(sh);
        ListNode dummy = new ListNode(0);
        ListNode th = dummy;
        while (list != null && sh != null){
            dummy.next = new ListNode(list.val);
            list = list.next;
            dummy = dummy.next;
            dummy.next = new ListNode(sh.val);
            sh = sh.next;
            dummy = dummy.next;
        }
        if (list != null){
            dummy.next = list;
        }
        if (sh != null)
            dummy.next = sh;
        return th.next;
    }

    private static ListNode reverse(ListNode sh) {
        if (sh == null || sh.next == null)
            return sh;
        ListNode temp = reverse(sh.next);
        sh.next.next = sh;
        sh.next = null;
        return temp;
    }

    private static ListNode findMid(ListNode list) {
        ListNode slow = list;
        ListNode fast = list;
        while (fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
