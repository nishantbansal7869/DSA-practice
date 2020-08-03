package com.practice.hackerRank;

import java.util.Scanner;

public class HalfDiamond {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printDiamond(n);
    }

    private static void printDiamond(int n) {
        for (int i = 1; i <= n; i++){
            for (int k = 1; k<= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = n-1; i > 0; i--){
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
