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
        int i = 1;
        int j = k-1;
        int ans = 0;
        while (i < j){
            int tempMax = Math.max(arr[i], arr[j]);
            ans += tempMax;
            i++;
            j--;
        }
        if (arr[0]>0)
            ans += 1;
        if (k%2==0 && arr[k/2] > 0)
            ans += 1;
        return ans;
    }
}
