package com.practice.hackerRank;

import java.util.Scanner;

public class HollowRectangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int l = sc.nextInt();
        printRectangle(w, l);
    }

    private static void printRectangle(int w, int l) {
        printSide(w);
        printLength(w, l);
        printSide(w);
    }

    private static void printLength(int w, int l) {
        l = l-2;
        for (int i = 1; i <= l; i++){
            System.out.print("*");
            for (int k = 1; k <= w - 2; k++){
                System.out.print(" ");
            }
            System.out.print("*");
            System.out.println();
        }
    }

    private static void printSide(int w) {
        for (int i = 1; i <= w; i++){
            System.out.print("*");
        }
        System.out.println();
    }

}
