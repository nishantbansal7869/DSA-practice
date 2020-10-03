package com.practice.interviewbit.linkedlists;

public class SortBinaryLinkedList {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(0);
        ListNode ans = sortBinary(list);
        System.out.println(ans.val);
    }

    private static ListNode sortBinary(ListNode list) {
        int count0 = 0;
        int count1 = 0;
        ListNode th = list;
        while (list != null){
            if (list.val == 0)
                count0++;
            else
                count1++;
            list = list.next;
        }
        list = th;
        while (list != null && count0 > 0){
                list.val = 0;
                list = list.next;
                count0--;
        }
        while (list != null && count1 > 0){
            list.val = 1;
            list = list.next;
            count1--;
        }
        return th;
    }
}
