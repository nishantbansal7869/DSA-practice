package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int[] ans = countArray(arr);
        Arrays.stream(ans).forEach(i -> System.out.println(i));
    }

    private static int[] countArray(int[] arr) {
        int[] count = new int[100];
        for (int i = 0; i < arr.length; i++)
            count[arr[i]]++;
        return count;
    }
}
