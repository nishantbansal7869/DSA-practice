package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
       /* a.add(1);
        a.add(2);
        a.add(3);
        a.add(3);
        a.add(4);
        a.add(5);
        a.add(6);
        b.add(3);
        b.add(3);
        b.add(5);*/
        a.add(10000000);
        b.add(10000000);
        ArrayList<Integer> outout = findIntersection(a,b);
        System.out.println(outout);
    }

    private static ArrayList<Integer> findIntersection(ArrayList<Integer> a, ArrayList<Integer> b) {
        int p1 = 0;
        int p2 = 0;
        ArrayList<Integer> output = new ArrayList<>();
        while (p1 < a.size() && p2 < b.size()){
            if ((long)a.get(p1) == (long)b.get(p2)){
                output.add(a.get(p1));
                p1++;
                p2++;
            }
            else if (a.get(p1) < b.get(p2))
                p1++;
            else
                p2++;
        }
        return output;
    }
}
