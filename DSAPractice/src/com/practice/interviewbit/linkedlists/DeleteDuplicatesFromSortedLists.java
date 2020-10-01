package com.practice.interviewbit.linkedlists;

public class DeleteDuplicatesFromSortedLists {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(1);
        list.next.next = new ListNode(1);
        list.next.next.next = new ListNode(1);
        list.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next = new ListNode(4);
        list.next.next.next.next.next.next = new ListNode(4);
        ListNode ans = removeDupes(list);
        System.out.print(ans.val);
    }

    private static ListNode removeDupes(ListNode list) {
        int count = 1;
        ListNode dummy = new ListNode(0);
        ListNode th = dummy;
        while (list != null){
            while (list.next != null && list.val == list.next.val) {
                count++;
                list = list.next;
            }
            if (count == 1){
                dummy.next = new ListNode(list.val);
                dummy = dummy.next;
                list = list.next;
                count = 1;
            }
            else {
                list = list.next;
                count = 1;
            }
        }
        return th.next;
    }
}
