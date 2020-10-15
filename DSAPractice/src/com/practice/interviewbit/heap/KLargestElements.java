package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int k = sc.nextInt();
        ArrayList<Integer> ans = kLargestElement(list, k);
        System.out.println(ans);
    }

    private static ArrayList<Integer> kLargestElement(ArrayList<Integer> list, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < k; i++)
            p.add(list.get(i));
        for (int i = k; i < list.size(); i++){
            if (list.get(i) > p.peek()) {
                p.poll();
                p.add(list.get(i));
            }
        }
        while (!p.isEmpty()){
            ans.add(p.poll());
        }
        return ans;
    }
}
