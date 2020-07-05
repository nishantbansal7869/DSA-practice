package com.practice.hackerRank;

import java.util.Scanner;

public class CheckIthBitSet {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int i = sc.nextInt();
        boolean isSet = check(n,i);
        System.out.print(isSet);
    }
    public static boolean check(int n, int i){
        if((n & 1<<i) != 0){
            return true;
        }
        return false;
    }
}
