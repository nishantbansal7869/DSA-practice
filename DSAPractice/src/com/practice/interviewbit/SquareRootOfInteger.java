package com.practice.interviewbit;

import java.util.Scanner;

public class SquareRootOfInteger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sqrt = findSquareRoot(n);
        System.out.println(sqrt);
        int m = (int)1e9+7;
    }

    private static int findSquareRoot(int n) {
        int root = 0;
        int low = 1;
        int high = n/2;
        while (low <= high){
            long mid = (low + high)/2;
            if (mid * mid == n)
                return (int)mid;
            else if (mid * mid > n)
                high = (int)mid - 1;
            else if ((long)(mid*mid) < n){
                root = (int)mid;
                low = (int)mid+1;
            }
        }
        return root;
    }
}
