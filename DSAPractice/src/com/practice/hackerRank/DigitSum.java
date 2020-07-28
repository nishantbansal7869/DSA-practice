package com.practice.hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class DigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner((System.in));
        String s = sc.next();
        BigInteger n = new BigInteger(s);
        BigInteger sum = new BigInteger("0");
        BigInteger zero = BigInteger.ZERO;
        while (!n.equals(zero)) {
            BigInteger[] remainder = n.divideAndRemainder(new BigInteger("10"));
            sum = sum.add(remainder[1]);
            n = n.divide(new BigInteger("10"));
        }
        System.out.println(sum);
    }
}
