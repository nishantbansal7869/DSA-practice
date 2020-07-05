package com.practice.sorting;

/*
* We are given an array of chocolates packets, we need to distribute chcocolate to m children in such a way that
* every child get at least 1 packet and the difference between minimum and maximum is minimum.
* */

import java.util.Arrays;

public class ChocolateDivisionProblem {
    public static void main(String[] args) {
        int arr[] = new int[]{7,3,2,4,9,12,13};
        int m = 3;
        System.out.println(chocolateDivision(arr,arr.length,m));
    }
    public static int chocolateDivision(int arr[], int n, int m){
        if(m > n)
            return -1;
        Arrays.sort(arr);
        int res = arr[m-1]-arr[0];
        for(int i = 1; i+m-1 < n; i++){
            res = Math.min(res,arr[i+m-1]-arr[i]);
        }
        return res;
    }
}
