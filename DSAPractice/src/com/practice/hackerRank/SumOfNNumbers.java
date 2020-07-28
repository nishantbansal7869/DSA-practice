package com.practice.hackerRank;

import java.util.Scanner;

public class SumOfNNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = sumOfnNum(n);
        System.out.println(sum);
    }
    private static long sumOfnNum(int n) {
        if(n == 1){
            return 1;
        }

        return square(n) + sumOfnNum(n - 1);
    }

    public static long cube(int n){
        return n * n * n;
    }

    public static long square(int n){
        return n * n;
    }
}
