package com.practice.hackerRank;

import java.util.Scanner;

public class InvertedPyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPyramid(n);
    }

    private static void printPyramid(int n) {
        for (int i = 0; i < n; i++){
            System.out.print("*" + " ");
        }
        System.out.println();
        for (int i = 1; i <= n - 2; i++){
            System.out.print("*"+ " ");
            for (int k = 1; k <= (n-i) - 2; k++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
        System.out.print("*");
    }
}
