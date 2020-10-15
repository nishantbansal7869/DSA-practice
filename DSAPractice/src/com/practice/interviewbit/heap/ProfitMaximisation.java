package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class ProfitMaximisation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int b = sc.nextInt();
        int ans = profitMax(list, b);
        System.out.println(ans);
    }

    private static int profitMax(ArrayList<Integer> list, int b) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        p.addAll(list);
        int ans = 0;
        while (b > 0){
            int a = p.poll();
            ans += a;
            p.add(a-1);
            b--;
        }
        return ans;
    }
}
