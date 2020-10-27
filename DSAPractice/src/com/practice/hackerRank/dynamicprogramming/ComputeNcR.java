package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class ComputeNcR {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        setBaseCond();
        findNcR(2000, 2000);
        while (test > 0){
            String[] s = br.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            int r = Integer.parseInt(s[1]);
            bw.write(getNcR(n, r)+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void setBaseCond() {
        for (int j = 1; j < dp.length; j++)
            dp[0][j] = 0;
        for (int i = 0; i < dp.length; i++)
            dp[i][0] = 1;
    }

    static int[][] dp = new int[2001][2001];
    private static void findNcR(int n, int r) {
        int m = (int)1e9+7;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= r; j++)
                dp[i][j] = (int)(((long)dp[i-1][j-1] + dp[i-1][j])%m);
        }
    }

    private static int getNcR(int n, int r){
        return dp[n][r];
    }
}
