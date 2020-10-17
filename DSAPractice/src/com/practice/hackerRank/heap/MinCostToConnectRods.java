package com.practice.hackerRank.heap;

import java.io.*;
import java.util.PriorityQueue;

public class MinCostToConnectRods {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(s[i]);
            int ans = minCost(arr);
            bw.write(ans + "");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int minCost(int[] arr) {
        PriorityQueue<Integer> p = new PriorityQueue<>();
        for (int i : arr)
            p.add(i);
        int ans = 0;
        while (p.size() != 1){
            int a = p.poll();
            int b = 0;
            if (!p.isEmpty())
                b = p.poll();
            ans = ans + a + b;
            p.add(a+b);
        }
        return ans;
    }
}
