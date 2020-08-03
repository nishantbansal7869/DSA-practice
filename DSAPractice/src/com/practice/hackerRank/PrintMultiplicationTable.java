package com.practice.hackerRank;

import java.util.Scanner;

public class PrintMultiplicationTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printTable(n);
    }

    private static void printTable(int n) {
        for (int i = 1; i <= 10; i++){
            System.out.print(n +  " * " + i + " = " + (n*i) );
            System.out.println();
        }
    }
}
