package com.practice.interviewbit.linkedlists;

public class RemoveNthNode {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = new ListNode(5);
        int n = 5;
        ListNode ans = removeNthNode(list, n);
        //System.out.print(ans.val);
    }

    private static ListNode removeNthNode(ListNode list, int n) {
      int size = getSize(list);
      ListNode prev = new ListNode(0);
        if(n > size || n == size)
            return list.next;
      n = size - n;
      ListNode th = list;
      while (n > 0){
          prev = list;
          list = list.next;
          n--;
      }
      prev.next = list.next;
      return th;
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
