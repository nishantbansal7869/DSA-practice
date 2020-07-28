package com.practice.hackerRank;

import java.util.Scanner;

public class ComputeAPowerB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int power = 1;
        while (b > 0){
            power = ((power%1000000007)*a)%1000000007;
            b--;
        }
        System.out.println(power);
    }
}
