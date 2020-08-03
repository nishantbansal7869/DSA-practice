package com.practice.hackerRank;

import java.util.Scanner;

public class PrintPyramind {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPyramid(n);
    }

    private static void printPyramid(int n) {
        for (int i = 1; i <= n; i++){
            for (int k = 1; k <= n-i; k++){
                System.out.print(" ");
            }
            for (int k = 1; k <= i; k++){
                System.out.print("*");
            }
            for (int k = 1; k < i; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
