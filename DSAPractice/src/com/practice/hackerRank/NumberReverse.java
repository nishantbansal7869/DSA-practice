package com.practice.hackerRank;

import java.util.Scanner;

public class NumberReverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long reverse = reverseNum(n);
        System.out.print(reverse);
    }

    private static Long reverseNum(Long n) {
        boolean isNegative = false;
        if (n < 0){
            isNegative = true;
            n = -n;
        }
        Long num = 0l;
        while (n > 0){
            num = (num * 10) + (n % 10);
            n /= 10;
        }
        if (isNegative)
            return -num;
        return num;
    }
}
