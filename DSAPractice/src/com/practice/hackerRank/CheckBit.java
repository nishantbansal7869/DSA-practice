package com.practice.hackerRank;

import java.util.Scanner;

public class CheckBit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();
        if( (n & (1 << i)) > 0){
            System.out.println(true);
        }
        else
            System.out.println(false);
        System.out.println(Integer.toBinaryString(n));
    }
}
