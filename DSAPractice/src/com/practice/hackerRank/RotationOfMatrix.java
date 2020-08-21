package com.practice.hackerRank;

import java.util.Scanner;

public class RotationOfMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
       for (int k = 1; k <= test; k++){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            printRotatedMatrix(arr, n, k);
        }
    }

    private static void printRotatedMatrix(int[][] arr, int n, int test) {
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                swapMatrix(arr,i,j);
            }
        }
        int k = 0;
        int j = n-1;
        int i;
        while (k <= j){
            for (i = 0; i < n; i++){
                swapElement(arr,i,j,k);
            }
            j--;
            k++;
        }
        System.out.println("Test Case #" + test + ":");
        for (int l = 0; l < n; l++){
            for (int m = 0; m < n; m++){
                System.out.print(arr[l][m] + " ");
            }
            System.out.println();
        }
    }

    private static void swapElement(int[][] arr, int i, int j, int k) {
        int temp = arr[i][k];
        arr[i][k] = arr[i][j];
        arr[i][j] = temp;
    }

    private static void swapMatrix(int[][] arr, int i, int j) {
        int  temp = arr[i][j];
        arr[i][j] = arr[j][i];
        arr[j][i] = temp;
    }
}
