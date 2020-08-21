package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumcontiguousSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            int length = maxSubsequence(arr,n);
            System.out.println(length);
            test--;
        }
    }

    private static int maxSubsequence(int[] arr, int n) {
        Arrays.sort(arr);
        int count  = 0;
        int tempCount = 0;
        for (int i = 0; i < n - 1; i++){
            if (arr[i+1] - arr[i] == 1)
                tempCount++;
            else {
                count = Math.max(count, tempCount != 0 ? tempCount+1 : 0);
                tempCount = 0;
            }
        }
        return Math.max(count, tempCount != 0 ? tempCount+1:0);
    }
}
