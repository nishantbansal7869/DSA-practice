package com.practice.hackerRank;

import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long factorial = factorial(n);
        System.out.println(factorial);
    }

    private static long factorial(int n) {
        if(n == 0){
            return 1;
        }
        return n * factorial(n-1);
    }
}
