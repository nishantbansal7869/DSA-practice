package com.practice.interviewbit;

import java.util.Scanner;

public class TrailingZeroesInAFactorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = trailingZeroes(n);
        System.out.println(ans);
    }

    private static int trailingZeroes(int n) {
        int count = 0;
        for (int i = 5; n/i >= 1; i*=5)
            count += n/i;
        return count;
    }
}
