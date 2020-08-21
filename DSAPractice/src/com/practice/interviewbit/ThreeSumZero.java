package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class ThreeSumZero {
    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(-4);
        a.add(0);
        a.add(0);
        a.add(5);
        a.add(-5);
        a.add(1);
        a.add(0);
        a.add(-2);
        a.add(4);
        a.add(-4);
        a.add(1);
        a.add(-1);
        a.add(-4);
        a.add(3);
        a.add(4);
        a.add(-1);
        a.add(-1);
        a.add(-3);
        ArrayList<ArrayList<Integer>> res = findParisSumZero(a);
        System.out.println(res);
    }

    private static ArrayList<ArrayList<Integer>> findParisSumZero(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (a.size() < 3)
            return res;
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++){
            long c = 0l - a.get(i);
                ArrayList<ArrayList<Integer>> ans = findPair(a, i+1, a.size(), c, a.get(i));
                for (ArrayList<Integer> list : ans)
                    if (!res.contains(list))
                    res.add(new ArrayList<>(list));
        }
        return res;
    }

    private static ArrayList<ArrayList<Integer>> findPair(ArrayList<Integer> a, int idx, int size, long c, int el) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int p1 = idx;
        int p2 = size-1;
        while (p1 < p2){
            long sum = (long)a.get(p1) + (long)a.get(p2);
            if (sum == c)
            {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(el);
                temp.add(a.get(p1));
                temp.add(a.get(p2));
                list.add(new ArrayList<>(temp));
                p1++;
                p2--;
            }
            else if (sum > c)
                p2--;
            else
                p1++;
        }
        return list;
    }
}
