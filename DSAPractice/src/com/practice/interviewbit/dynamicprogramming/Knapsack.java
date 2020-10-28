package com.practice.interviewbit.dynamicprogramming;

import java.util.Scanner;

public class Knapsack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] value = new int[n];
        int[] weight = new int[n];
        for (int i = 0; i < n; i++)
            value[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            weight[i] = sc.nextInt();
        int s = sc.nextInt();
        int ans = findMAxValue(value, weight, s);
        System.out.println(ans);
    }

    private static int findMAxValue(int[] value, int[] weight, int s) {
        int n = value.length;
        int[][] dp = new int[n+1][s+1];
        for (int i = 0; i <= s; i++)
            dp[0][i] = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= s; j++) {
                if (s >= weight[i-1] && j >= weight[i-1])
                    dp[i][j] = Math.max(dp[i-1][j-weight[i-1]]+value[i-1], dp[i-1][j]);
                else
                    dp[i][j] = Math.max(0, dp[i-1][j]);
            }
        }
        return dp[n][s];
    }
}
