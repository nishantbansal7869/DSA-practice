package com.practice.hackerRank;

import java.util.Scanner;

public class SockMerchant {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int pairs = countPairs(arr, n);
        System.out.println(pairs);
    }

    private static int countPairs(int[] arr, int n) {
        int[] temp = new int[101];
        for (int i : arr){
            temp[i]++;
        }
        int pairs = 0;
        for (int  i = 1 ; i <= 100; i++){
            pairs += temp[i] % 2;
        }
        return pairs;
    }
}
