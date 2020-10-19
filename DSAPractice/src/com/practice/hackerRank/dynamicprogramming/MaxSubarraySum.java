package com.practice.hackerRank.dynamicprogramming;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class MaxSubarraySum {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] sArr = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            int ans[] = maxSubarraySum(arr);
            for (int i : ans)
            bw.write(i+" ");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int[] maxSubarraySum(int[] arr) {
        Integer[] dp = new Integer[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
           if (dp[i-1] < 0)
               dp[i] = arr[i];
           else
               dp[i] = dp[i-1]+arr[i];
        }
        int[] ans = new int[3];
        ans[0] = Collections.max(Arrays.asList(dp));
        int j = 0;
        int k = 0;
        for (int i = 0; i < dp.length; i++){
            if (dp[i] == ans[0]) {
                j = i;
                break;
            }
        }
        for (int i = j; i >= 0; i--){
            if (dp[i] < 0){
                k = i+1;
                break;
            }
        }
        ans[1] = k;
        ans[2] = j;
        return ans;
    }
}
