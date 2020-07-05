package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumElementInAnArray {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int max = findMax(arr,n);
        System.out.println(max);
    }
    public static int findMax(int[] arr, int n){
        Arrays.sort(arr);
        return arr[n-1];
    }
}
