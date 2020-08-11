package com.practice.codeforces;

import java.util.Scanner;

public class NearlyLuckyNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        String s = nearlyLucky(n);
        System.out.print(s);
    }

    private static String nearlyLucky(long n) {
        if(lengthOfn(n) < 4)
            return "NO";
        int countOf4and7 = 0;
        while (n > 0){
            int num = (int)(n%10);
            if (num == 4 || num == 7)
                countOf4and7++;
            n/=10;
            }
        if (countOf4and7 == 7 || countOf4and7 == 4)
            return "YES";
        return "NO";
    }

    private static int lengthOfn(long n) {
        return (int)Math.log10(n)+1;
    }
}
