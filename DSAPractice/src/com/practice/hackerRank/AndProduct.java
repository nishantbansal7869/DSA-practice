package com.practice.hackerRank;

import sun.nio.cs.ext.MacArabic;

import java.util.Scanner;

public class AndProduct {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long result = andProduct(a, b);
            System.out.print(result);
        }
    }

    private static long andProduct(long a, long b) {
       int lastBita = findLastBit(a);
       int lastBitb = findLastBit(b);
       int MSBa = findMSB(a);
       int MSBb = findMSB(b);
       if (lastBita != 0 && lastBitb != 0) {
           if (MSBa == MSBb)
               return (long)Math.pow(2, MSBb);
           else
               return 0;
       }
       else
           if (MSBa == MSBb)
               return a&b;
           else
               return 0;
    }

    private static int findLastBit(long a) {
        return (int)a&1;
    }

    private static int findMSB(long a){
        for (int i = 31; i >= 0; i--)
            if ((a&(1l<<i)) != 0)
                return i;
        return 0;
    }

}
