package com.practice.interviewbit;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int gcd = gcd(a,b);
        System.out.println(gcd);
    }

    private static int gcd(int a, int b) {
        if (a == 0)
            return b;
        return gcd(b%a,a);
    }
}
