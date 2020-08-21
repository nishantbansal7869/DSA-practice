package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PairWithGivenDifference {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(-259);
        a.add(-825);
        a.add(459);
        a.add(825);
        a.add(221);
        a.add(870);
        a.add(626);
        a.add(934);
        a.add(205);
        a.add(783);
        a.add(850);
        a.add(398);
        int b = -42;
        int res = fidPairWithDiff(a, b);
        System.out.println(res);
    }

    private static int fidPairWithDiff(ArrayList<Integer> a, int b) {
        Collections.sort(a);
       for (int i = 0; i < a.size(); i++){
           int c = Math.abs(b) + a.get(i);
           boolean exist = BSR(a, c, i + 1, a.size()-1);
           if (exist)
               return 1;
       }
       return 0;
    }

    private static boolean BSR(ArrayList<Integer> a, int c, int low, int high) {
        if (low > high)
            return false;
        int mid = (low+high)/2;
        if (a.get(mid) == c)
            return true;
        if (a.get(mid) > c)
            return BSR(a, c, low, mid -1);
        return BSR(a, c, mid + 1, high);
    }
}
