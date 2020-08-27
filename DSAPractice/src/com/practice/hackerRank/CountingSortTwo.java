package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class CountingSortTwo {
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
        for(int i = 0; i < arr.length; i++)
            count[arr[i]]++;
        int k = 0;
        for(int i = 0; i < 100; i++){
            int cnt = count[i];
            while(cnt > 0)
            {
                arr[k] = i;
                k++;
                cnt--;
            }
        }
        return arr;
    }
}
