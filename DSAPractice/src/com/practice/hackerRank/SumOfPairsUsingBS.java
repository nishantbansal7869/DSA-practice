package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfPairsUsingBS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            boolean exist = sumOfPair(arr, n, k);
            if (exist)
                System.out.println("True");
            else
                System.out.println("False");
            test--;
        }
    }

    private static boolean sumOfPair(int[] arr, int n, int k) {
        Arrays.stream(arr);
        for (int i = 0; i < n; i++){
            int a = k - arr[i];
            boolean exist = BSR(arr, a, i+1, n-1);
            if (exist)
                return true;
        }
        return false;
    }

    private static boolean BSR(int[] arr, int a, int low, int high) {
        if (low > high)
            return false;
        int mid = (low + high)/2;
        if (arr[mid] == a)
            return true;
        if (arr[mid] > a)
        return BSR(arr, a, low, mid - 1);
        return BSR(arr, a, mid + 1, high);
    }
}
