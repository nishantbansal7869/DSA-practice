package com.practice.hackerRank;

import java.math.BigInteger;
import java.util.Scanner;

public class AreaOfRectangle {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        BigInteger l = sc.nextBigInteger();
        BigInteger b = sc.nextBigInteger();
        BigInteger area = l.multiply(b);
        System.out.println(area);
    }
}
