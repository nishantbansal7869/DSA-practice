package com.practice.interviewbit.linkedlists;

public class SwapListNodesInPairs {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        //list.next = new ListNode(2);
       // list.next.next = new ListNode(3);
        //list.next.next.next = new ListNode(4);
        ListNode ans = swapNodes(list);
        System.out.print(ans.val);
    }

    private static ListNode swapNodes(ListNode list) {
        if (list == null || list.next == null)
            return list;
      ListNode dummy = new ListNode(0);
      ListNode th = dummy;
      ListNode h1 = list;
      while (h1 != null && h1.next != null){
          dummy.next = new ListNode(h1.next.val);
          dummy.next.next = new ListNode(h1.val);
          dummy = dummy.next.next;
          h1 = h1.next.next;
      }
      if (h1 != null && h1.next == null)
          dummy.next = new ListNode(h1.val);
      return th.next;
    }
}
