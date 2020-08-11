package com.practice.hackerRank;

import java.util.Scanner;

public class RecursiveDigitSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        int k = sc.nextInt();
        int res = superDigit(n, k);
        System.out.println(res);
    }

    private static int superDigit(String n, int k) {
        String num1 = sumOfDigit(n);
        Long num = Long.parseLong(num1) * k;
        String res = findSum(num.toString());
        return Integer.parseInt(res);
    }

    static String findSum(String num){
        if(num.length() == 1)
            return num;
        return findSum(sumOfDigit(num));
    }

    static String sumOfDigit(String n){
        Long num = 0l;
        for(int i = 0; i < n.length(); i++){
            num = num + Long.parseLong(String.valueOf(n.charAt(i)));
        }
        return num.toString();
    }
}
