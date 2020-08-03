package com.practice.hackerRank;

import java.util.Scanner;

public class PallindromePyramid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPyramid(n);
    }

    private static void printPyramid(int n) {
        for (int i = 1; i <= n; i++){
            int ch = 'A';
            for (int k = 1; k <= i; k++){
                System.out.print((char)ch + " ");
                ch += 1;
            }
            ch -= 1;
            for (int k = 1; k < i; k++){
                ch -= 1;
                System.out.print((char)ch + " ");
            }
            System.out.println();
        }
    }
}
