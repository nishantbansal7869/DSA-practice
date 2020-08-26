package com.practice.hackerRank;

import java.util.Scanner;

public class DiagonalTraversalOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    arr[i][j] = sc.nextInt();
            diagonalSum(arr, n);
            System.out.println();
            test--;
        }
    }

    private static void diagonalSum(int[][] arr, int n) {
        int i = 0;
        int k = 1;
        int j = n-k;
        int sum = 0;
        while (j >= 0){
            while (i < n && j < n){
                sum += arr[i][j];
                i++;
                j++;
            }
            System.out.print(sum + " ");
            sum = 0;
            k++;
            j = n - k;
            i = 0;
        }
        k = 1;
        i = k;

        while (i < n){
            j = 0;
            while (i < n && j < n){
                sum += arr[i][j];
                i++;
                j++;
            }
            System.out.print(sum + " ");
            sum = 0;
            k++;
            i = k;
        }
    }
}
