package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class TheKnapsackProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String s2[] = br.readLine().split(" ");
            int s = Integer.parseInt(s2[0]);
            int n = Integer.parseInt(s2[1]);
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++){
                String[] s1 = br.readLine().split(" ");
                arr[i][0] = Integer.parseInt(s1[0]);
                arr[i][1] = Integer.parseInt(s1[1]);
            }
            int ans = findMaxValue(arr, s, n);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }
    static int[][] dp = new int[501][501];
    private static int findMaxValue(int[][] arr, int s, int n) {
        if (n == 0)
            return 0;
        if (s >= arr[n - 1][0]){
            dp[n][s] = Math.max(findMaxValue(arr, s-arr[n-1][0], n-1) + arr[n-1][1], findMaxValue(arr, s, n-1));
        }
        else
        {
            dp[n][s] = Math.max(0, findMaxValue(arr, s, n-1));
        }
        return dp[n][s];
    }
}
