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
    private static int findMaxValue(int[][] arr, int s, int n) {
        int[][] dp = new int[n+1][s+1];
        for (int i = 0; i <= s; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= s; j++){
                if (s >= arr[i-1][0] && j >= arr[i-1][0])
                    dp[i][j] = Math.max(dp[i-1][j - arr[i-1][0]]+arr[i-1][1], dp[i-1][j]);
                else
                    dp[i][j] = Math.max(0, dp[i-1][j]);
            }
        }
        return dp[n][s];
    }
}
