package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class NumberOfDiceRollsForGivenSum{
    public static void main(String[] args)throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        dp[0] = 1;
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int ans = numberOfDiceRolls(n);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }
    static int[] dp = new int[(int)1e6];
    static int idx = 1;
    private static int numberOfDiceRolls(int n) {
        if (dp[n] != 0)
            return dp[n];
        int m = (int)1e9+7;
        for (int i = idx; i <= n; i++){
            int ans = 0;
            for (int j = 1; j <= 6 && (i-j) >= 0; j++)
                ans = (int)(((long)ans+dp[i-j])%m);
            dp[i] = ans;
        }
        idx = n;
        return dp[n];
    }
}
