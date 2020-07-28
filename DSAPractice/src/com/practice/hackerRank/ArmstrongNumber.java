package com.practice.hackerRank;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = isAramstrong(n);
        System.out.println(s);
    }

    private static String isAramstrong(int n) {
        int num = checkArmstrong(n);
        if(num == n){
            return "Yes";
        }
        else
            return "No";
    }

    private static int checkArmstrong(int n) {
        if(n == 0){
            return 0;
        }
        return cube(n % 10) + checkArmstrong(n / 10);
    }

    public static int cube(int n){
        return n*n*n;
    }
}
