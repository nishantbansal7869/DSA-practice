package com.practice.hackerRank;

import java.util.Scanner;

public class RectanglePattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printRectangle(n);
    }

    private static void printRectangle(int n) {
        for (int i = 1; i <= n; i++){
            for (int k = n; k >= 1; k--){
                if (k == i){
                    System.out.print("*");
                }
                else
                    System.out.print(k);
            }
            System.out.println();
        }
    }
}
