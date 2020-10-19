package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class ComputeFactorial {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        dp[0] = 1;
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int ans = findFactorial(n);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }
    static int[] dp = new int[(int)1e6];
    static int index = 1;
    private static int findFactorial(int n) {
        int m = (int)1e9+7;
        if (dp[n] != 0)
            return dp[n];
        for (int i = index; i <= n; i++){
            dp[i] = (int)(((long)dp[i-1]*i)%m);
        }
        index = n;
        return dp[n];
    }
}
