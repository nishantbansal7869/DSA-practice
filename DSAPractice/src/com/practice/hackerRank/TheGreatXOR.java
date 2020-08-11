package com.practice.hackerRank;

import java.util.Scanner;

public class TheGreatXOR {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long x = sc.nextInt();
        long result = theGreatXOr(x);
        System.out.print(result);
    }

    private static long theGreatXOr(long x) {
        int totalBits = 0;
        for (int i = 63; i>= 0; i--){
            if ((x&(1l<<i)) != 0){
                totalBits = i;
                break;
            }
        }
        int countOf1 = 0;
        for (int i = totalBits; i >= 0; i--){
            if ((x&(1l<<i)) != 0){
                countOf1++;
            }
        }
        if (x % 2 == 0){
            return (long)(Math.pow(2,totalBits) - Math.pow(2,countOf1)) + 1;
        }
        else
            return (long)(Math.pow(2,totalBits) - Math.pow(2,countOf1 - 1));
    }
}
