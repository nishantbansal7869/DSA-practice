package com.practice.interviewbit.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MagicianAndChocolates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++)
            list.add(i, sc.nextInt());
        int ans = nChoc(list,a);
        System.out.println(ans);
    }

    private static int nChoc(ArrayList<Integer> list, int a) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());
        int m = (int)1e9+7;
        p.addAll(list);
        int ans = 0;
        while (a > 0){
            int n = p.poll();
            ans = (int) (((long)(ans)+n)%m);
            n = (int)Math.floor(n/2);
            p.add(n);
            a--;
        }
        return ans;
    }
}
