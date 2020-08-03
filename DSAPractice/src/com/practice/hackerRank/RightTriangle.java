package com.practice.hackerRank;

import java.util.Scanner;

public class RightTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printPattern(n);
    }

    private static void printPattern(int n) {
        for (int i = 1; i <= n; i++){
            System.out.print(i + " ");
            int j = i;
            for (int k = 1; k < i; k++){
                j = j + (n - k);
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
