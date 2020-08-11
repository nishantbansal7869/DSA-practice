package com.practice.hackerRank;

import java.util.Scanner;

public class SumVsXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long count = sumVsXor(n);
        System.out.print(count);
    }

    private static long sumVsXor(long n) {
        if (n == 0)
            return 1;
        int bit = 0;
       for (int i = 63; i >= 0; i--){
           if ((n&(1l<<i)) != 0){
                bit = i;
                break;
           }
       }
       int count = 0;
       for (int i = bit; i >= 0; i--){
           if ((n&(1l<<i)) == 0){
               count++;
           }
       }
       return (long)Math.pow(2,count);
    }
}
