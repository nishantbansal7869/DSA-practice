package com.practice.hackerRank;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class MaximumcontiguousSubsequence {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String a = br.readLine();
            String[] sArr = a.split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(sArr[i]);
            int ans = maxSubsequence(arr, n);
            bw.write(ans + " ");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int maxSubsequence(int[] arr, int n) {
        int ans = 0;
        HashSet<Integer> tempSet = new HashSet<>();
        for(int i : arr){
            tempSet.add(i);
        }
        int[] arr1 = new int[tempSet.size()];
        int idx = 0;
        for (int i : tempSet)
            arr1[idx++] = i;
        Arrays.sort(arr1);
        for(int i = 0; i < arr1.length; i++){
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for(int j = i; j < arr1.length; j++){
                min = Math.min(min, arr1[j]);
                max = Math.max(max, arr1[j]);
                if(max - min + 1 == j - i + 1){
                    ans = Math.max(ans, j-i+1);
                    if (ans == tempSet.size())
                        return ans;
                }
            }
        }
        return ans;
    }
}
