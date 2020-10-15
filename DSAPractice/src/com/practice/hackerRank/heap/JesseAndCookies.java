package com.practice.hackerRank.heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class JesseAndCookies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ans = cookies(k, arr);
        System.out.println(ans);
    }

    private static int cookies(int k, int[] arr) {
        if (arr.length == 1 && arr[0] < k)
            return -1;
        int count = 0;
        PriorityQueue<Long> p = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++)
            p.add((long)arr[i]);
        while (!p.isEmpty()){
            long c1 = p.poll();
            if (c1 >= k)
                return count;
            if (p.isEmpty())
                return -1;
            long c2 = p.poll();
            long sweet = c1 + 2*c2;
            p.add(sweet);
            count++;
        }
        return -1;
    }
}
