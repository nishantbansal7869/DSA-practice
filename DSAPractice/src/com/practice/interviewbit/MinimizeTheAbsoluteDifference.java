package com.practice.interviewbit;

import java.util.ArrayList;
import java.util.Scanner;

public class MinimizeTheAbsoluteDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>(n);
        ArrayList<Integer> b = new ArrayList<>(m);
        ArrayList<Integer> c = new ArrayList<>(l);
        for (int i = 0; i < n; i++)
            a.add(i, sc.nextInt());
        for (int i = 0; i < m; i++)
            b.add(i, sc.nextInt());
        for (int j = 0; j < l; j++)
            c.add(j, sc.nextInt());
        int ans = minAbsoluteDifference(a, b, c);
        System.out.println(ans);
    }

    private static int minAbsoluteDifference(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        int p1 = 0;
        int p2 = 0;
        int p3 = 0;
        int ans = Integer.MAX_VALUE;
        while (p1 < a.size() && p2 < b.size() && p3 < c.size()){
            int max = Math.max(a.get(p1), b.get(p2));
            max = Math.max(max, c.get(p3));

            int min = Math.min(a.get(p1), b.get(p2));
            min = Math.min(min, c.get(p3));

            ans = Math.min(ans, max - min);

            if (a.get(p1) == min)
                p1++;
            else if (b.get(p2) == min)
                p2++;
            else
                p3++;
        }
        return ans;
    }
}
