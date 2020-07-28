package com.practice.hackerRank;

import java.util.Scanner;

public class MissingInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = 10;
        int[] arr = new int[n];
        for(int i = 1; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int missingInt = missingInt(arr, n);
        System.out.println(missingInt);
    }

    private static int missingInt(int[] arr, int n) {
        int sumtillN = 0;
        for(int i = 1; i <= n; i++){
            sumtillN = sumtillN ^ i;
        }
        int sumOfArr = 0;
        for(int i = 0; i < arr.length; i++){
            sumOfArr = sumOfArr ^ arr[i];
        }
        return sumOfArr ^ sumtillN;
    }
}
