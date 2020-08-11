package com.practice.hackerRank;

import java.util.Scanner;

public class XORSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long l = sc.nextLong();
        long r = sc.nextLong();
        long result = xorSeq(l,r);
        System.out.print(result);
    }

    private static long xorSeq(long l, long r) {
        long x = 0l;
        long a = 0;
        long a1 = 0;
        for (x = 1; x <= l; x++){
            a1 = a ^ x;
            a = a1;
        }
        long result = 0;
        for (long i = l+1; i <= r; i++){
            result = result ^ a;
            a1 = a ^ i;
            a = a1;
        }
        result = result ^ a;
        return result;
    }
}
