package com.practice.hackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class NonDivisibleSubSet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(n);
        int k = sc.nextInt();
        for (int i = 0; i < n; i++)
            list.add(i,sc.nextInt());
        int lenOfSubset = nonDivByK(k,list);
        System.out.println(lenOfSubset);
    }

    private static int nonDivByK(int k, ArrayList<Integer> list) {
        int[] arr = new int[k];
        for (int i : list){
            arr[i%k]++;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < k-1; i++){
            for (int j = i+1; j < k; j++){
                if (i + j != k) {
                   int  tempMax = Math.max(arr[i], arr[j]);
                   max = Math.max(max, tempMax);
                }
            }
        }
        return max;
    }
}
