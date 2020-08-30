package com.practice.hackerRank;

import java.util.Scanner;

public class FindingCubeRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            long n = sc.nextLong();
            long res = findCubeRoot(n);
            System.out.println(res);
            test--;
        }
    }

    private static long findCubeRoot(long n) {
        boolean negSign = n < 0;
        if (negSign)
            n = -1 * n;
        long low = 1;
        long high = (long)1e6;
        while (low <= high){
            long mid = (low+high)/2;
            long mul = mid*mid*mid;
            if (mul == n)
                return negSign ? -mid : mid;
            if (mul > n)
                high = mid-1;
            else
                low = mid + 1;
        }
        return negSign ? -1 : 1;
    }
}
