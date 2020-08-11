package com.practice.hackerRank;

import java.util.Scanner;

public class FlippingBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long result = flipBits(n);
        System.out.print(result);
    }

    private static long flipBits(long n) {
        for (int i = 0; i < 32; i++){
            n = n^(1l<<i);
        }
        return n;
    }
}
