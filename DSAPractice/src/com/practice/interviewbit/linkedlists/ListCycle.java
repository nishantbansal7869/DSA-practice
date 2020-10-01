package com.practice.interviewbit.linkedlists;

public class ListCycle {
    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);
        list.next.next.next.next = list.next.next;
        ListNode node = detectCycle(list);
        System.out.print(node.val);
    }

    private static ListNode detectCycle(ListNode list) {
       ListNode s = list;
       ListNode f = list;
       boolean cycleExist = false;
       while (f.next != null && f.next.next != null){
           s = s.next;
           f = f.next.next;
           if (s == f){
               cycleExist = true;
               break;
           }
       }
       if (!cycleExist)
           return null;
       ListNode p1 = list;
       ListNode p2 = s;
       while (p1 != p2){
           p1 = p1.next;
           p2 = p2.next;
       }
       return p1;
    }
}
