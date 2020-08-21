package com.practice.hackerRank;

import java.util.Scanner;

public class SumOfPairs {
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
        mergeSorts(arr, 0, n-1);
        int p1 = 0;
        int p2 = n-1;
        while (p1 < p2){
            long sum = arr[p1] + arr[p2];
            if (sum == k)
                return true;
            if (sum > k)
                p2--;
            else
                p1++;
        }
        return false;
    }

    private static void mergeSorts(int[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = (low+high)/2;
        mergeSorts(arr, low, mid);
        mergeSorts(arr, mid+1, high);
        merge(arr, low, high);
    }

    private static void merge(int[] arr, int low, int high) {
        int mid = (low+high)/2;
        int[] temp = new int[high-low+1];
        int p1 = low, p2 = mid+1, k = 0;
        while (p1 <= mid && p2 <= high){
            if (arr[p1] > arr[p2]){
                temp[k++] = arr[p2++];
            }
            else {
                temp[k++] = arr[p1++];
            }
        }
        while (p1 <= mid)
            temp[k++] = arr[p1++];
        while (p2 <= high)
            temp[k++] = arr[p2++];
        for (int i = 0; i < k; i++){
            arr[low + i] = temp[i];
        }
    }
}
