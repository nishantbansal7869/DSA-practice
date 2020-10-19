package com.practice.hackerRank.dynamicprogramming;

import java.io.*;

public class BinaryStringWithNoAdjacent1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        dp0[1] = 1;
        dp1[1] = 1;
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int ans = binaryStringCount(n);
            bw.write(ans+"");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    static int[] dp0 = new int[(int)1e6];
    static int[] dp1 = new int[(int)1e6];
    static int idx = 2;
    private static int binaryStringCount(int n) {
        int m = (int)1e9+7;
        if (dp1[n] != 0)
            return (int)(((long)dp0[n]+dp1[n])%m);
        for (int i = idx; i <= n; i++){
            dp0[i] = (int)(((long)dp0[i-1]+dp1[i-1])%m);
            dp1[i] = dp0[i-1];
        }
        return (int)(((long)dp0[n]+dp1[n])%m);
    }
}
