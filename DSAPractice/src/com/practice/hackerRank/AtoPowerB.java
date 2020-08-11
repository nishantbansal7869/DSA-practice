package com.practice.hackerRank;

import java.util.Scanner;

public class AtoPowerB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        long output = findAtoPowerB(a,b);
        System.out.print(output);
    }
    private static long findAtoPowerB(int a, int b){
        long m = (long)1e9+7;
        if(b == 0)
            return 1;
        long x = findAtoPowerB(a, b/2);
        if(b % 2 == 0)
            return x*x;
        return x*x*a;
    }
}
