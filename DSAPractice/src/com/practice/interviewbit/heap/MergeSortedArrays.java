package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergeSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++){
            ArrayList<Integer> l = new ArrayList<>();
            for (int j = 0; j < m; j++)
                l.add(j, sc.nextInt());
            list.add(new ArrayList<>(l));
        }
        ArrayList<Integer> ans = mergeArray(list);
        System.out.println(ans);
    }

    private static ArrayList<Integer> mergeArray(ArrayList<ArrayList<Integer>> list) {
        PriorityQueue<PairArray> p = new PriorityQueue<>(new ComparePair());
        int n = 0;
        for (ArrayList<Integer> l : list) {
            p.add(new PairArray(l.get(0), n, 0));
            n++;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while (!p.isEmpty()){
            PairArray p1 = p.poll();
            ans.add(p1.val);
            p1.m += 1;
            if (p1.n < list.size() && p1.m < list.get(p1.n).size())
                p.add(new PairArray(list.get(p1.n).get(p1.m), p1.n, p1.m));
        }
        return ans;
    }

}

class PairArray{
    int val;
    int n;
    int m;
    PairArray(int val, int n, int m){
        this.val = val;
        this.n = n;
        this.m = m;
    }
}

class ComparePair implements Comparator<PairArray>{

    @Override
    public int compare(PairArray o1, PairArray o2) {
        return o1.val - o2.val;
    }
}
