package com.practice.hackerRank;

import java.io.*;

public class SumOfSubarrays {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] sarr = s.split(" ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(sarr[i]);
        long[] sum = computeSum(arr, n);
        int q = Integer.parseInt(br.readLine());
        while (q > 0){
            String s1 = br.readLine();
            String[] arr1 = s1.split(" ");
            int i = Integer.parseInt(arr1[0]);
            int j = Integer.parseInt(arr1[1]);
            long ans = findSum(i, j, sum);
            bw.write(ans + "");
            bw.newLine();
            q--;
        }
        bw.flush();
        bw.close();
        br.close();
    }

    private static long findSum(int i, int j, long[] sum) {
        long ans = sum[j] - (i == 0 ? 0 : sum[i-1]);
        return ans;
    }

    private static long[] computeSum(int[] arr, int n) {
        long[] sum = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i-1] + arr[i];
        return sum;
    }
}

