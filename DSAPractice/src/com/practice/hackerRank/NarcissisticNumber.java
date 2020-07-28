package com.practice.hackerRank;

import java.util.Scanner;

public class NarcissisticNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = isNarcissistic(n);
        System.out.println(s);
    }
    static String isNarcissistic(int n){
        int pow = numberOfDigits(n);
        int num = checkNarcissistic(n, pow);
        if(num == n){
            return "Yes";
        }
        else
            return "No";
    }
    static int checkNarcissistic(int n, int pow){
        if(n == 0)
            return 0;
        return powerOfDigits(n % 10, pow) + checkNarcissistic(n / 10, pow);

    }

    private static int powerOfDigits(int n, int pow) {
        if(pow == 1)
            return n;
       return n * powerOfDigits(n, pow-1);
    }

    private static int numberOfDigits(int n) {
        return (int) Math.log10(n) + 1;
    }
}
