package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class CabinetPartitioning {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            long res = cabinetPartitioning(arr, n, k);
            System.out.println(res);
            test--;
        }
    }

    private static long cabinetPartitioning(int[] arr, int n, int k) {
        long ans = 0;
        long low = 0;
        long sum = Arrays.stream(arr).sum();
        long high = sum;
        while (low <= high){
            long mid = (low+high)/2;
            if (valid(mid, arr, n, k)){
                ans = mid;
                high = mid-1;
            }
            else
                low = mid+1;
        }
        return ans;
    }

    private static boolean valid(long mid, int[] arr, int n, int k) {
        long curSum = 0;
        int i = 0;
        while (i < n){
            if (arr[i] > mid)
                return false;
            curSum += arr[i];
            if (curSum > mid){
                curSum = arr[i];
                k--;
                if (k == 0)
                    break;
            }
            i++;
        }
        if (k == 0 && i != n)
            return false;
        return true;
    }
}
