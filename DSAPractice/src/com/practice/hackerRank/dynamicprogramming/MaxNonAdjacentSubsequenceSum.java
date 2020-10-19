package com.practice.hackerRank.dynamicprogramming;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class MaxNonAdjacentSubsequenceSum {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            String[] sArr = br.readLine().split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            int ans = maxSubsequenceSum(arr);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int maxSubsequenceSum(int[] arr) {
        Integer[] dp = new Integer[arr.length];
        dp[0] = arr[0];
        dp[1] = arr[1];
        int m = Math.max(0, arr[0]);
        for (int i = 2; i < arr.length; i++){
            dp[i] = m+arr[i];
            m = Math.max(m, dp[i-1]);
        }
        return Collections.max(Arrays.asList(dp));
    }
}
