package com.practice.interviewbit;

import java.util.Scanner;

public class SetBits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int bits = countbits(n);
        System.out.println(bits);
    }

    private static int countbits(long n) {
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);
        }
return count;
    }
}
