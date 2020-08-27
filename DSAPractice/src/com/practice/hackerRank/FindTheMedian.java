package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheMedian {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ans = findMedian(arr);
        System.out.println(ans);
    }

    private static int findMedian(int[] arr) {
        Arrays.sort(arr);
        int mid = arr.length/2;
        return arr[mid];
    }
}
