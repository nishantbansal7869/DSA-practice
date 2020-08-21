package com.practice.hackerRank;

import java.util.Scanner;

public class LcmAndHcf {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            long a = sc.nextLong();
            long b = sc.nextLong();
            findLcmAndHcf(a, b);
            test--;
        }
    }

    private static void findLcmAndHcf(long a, long b) {
        int m = (int)1e9+7;
        long hcf = findGcd(a,b);
        long lcm = a*b/hcf;
        System.out.print(lcm + " " + hcf);
        System.out.println();
    }

    private static long findGcd(long a, long b) {
        if (a == 0)
            return b;
        return findGcd(b%a, a);
    }
}
