package com.practice.interviewbit;

import java.util.ArrayList;

public class MergeTwoSortedList {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        a.add(5);
        a.add(8);
        a.add(10);
        b.add(2);
        b.add(3);
        b.add(7);
        b.add(9);
        b.add(11);
        mergeList(a,b);
        a.stream().forEach(i->System.out.println(i));
    }

    private static void mergeList(ArrayList<Integer> a, ArrayList<Integer> b) {
        int p1 = 0;
        int p2 = 0;
        while (p1 < a.size() && p2 < b.size()){
            if (a.get(p1) > b.get(p2)){
                a.add(p1, b.get(p2));
                p1++;
                p2++;
            }
            else
                p1++;
        }
        while (p2 < b.size())
            a.add(b.get(p2++));
    }
}
