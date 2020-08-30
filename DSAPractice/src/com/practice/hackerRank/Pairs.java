package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class Pairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ans = pairs(arr, k);
        System.out.println(ans);
    }

    private static int pairs(int[] arr, int k) {
        Arrays.sort(arr);
        int count = 0;
        int i = 0;
        int j = 1;
        while (i < arr.length && j < arr.length){
            if (i == arr.length-1 && j == arr.length-1)
                break;
            if (i == j)
               j++;
            if (arr[j] - arr[i] == k) {
                count++;
                j++;
            }
            else if (arr[j] - arr[i] > k)
                i++;
            else
                j++;
        }
        return count;
    }
}
