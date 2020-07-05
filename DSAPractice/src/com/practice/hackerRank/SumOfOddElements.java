package com.practice.hackerRank;

import java.util.Scanner;

public class SumOfOddElements {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int sum = sumEl(arr,n);
        System.out.print(sum);
    }
    public static int sumEl(int[] arr, int n){
        int sum = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 != 0){
                sum = (sum + arr[i]) % 1000000007;
            }
        }
        return sum;
    }
}
