package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(10);
        l1.next.next = new ListNode(20);
        ListNode l2 = new ListNode(4);
        l2.next = new ListNode(11);
        l2.next.next = new ListNode(13);
        ListNode l3 = new ListNode(3);
        l3.next = new ListNode(8);
        l3.next.next = new ListNode(9);
        ArrayList<ListNode> list = new ArrayList<>();
        list.add(l1);
        list.add(l2);
        list.add(l3);
        ListNode ans = mergeList(list);

    }

    private static ListNode mergeList(ArrayList<ListNode> list) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        PriorityQueue<Pair> p = new PriorityQueue<>(new Compare());
        for (ListNode l : list)
           p.add(new Pair(l.val, l));
        while (!p.isEmpty()){
            ListNode temp = p.poll().node;
            dummy.next = temp;
            if (temp.next != null)
                p.add(new Pair(temp.next.val, temp.next));
            dummy = dummy.next;
        }
        return head.next;
    }
}

class Pair{
    int val;
    ListNode node;
    Pair(int val, ListNode node){
        this.val = val;
        this.node = node;
    }
}

class Compare implements Comparator<Pair>{

    @Override
    public int compare(Pair o1, Pair o2) {
        return o1.val- o2.val;
    }
}

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        next = null;
    }
}