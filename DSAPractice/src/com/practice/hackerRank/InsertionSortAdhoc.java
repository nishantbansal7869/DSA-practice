package com.practice.hackerRank;

import java.util.Scanner;

public class InsertionSortAdhoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            insertionSortAdhoc(arr, n);
            System.out.println();
            test--;
        }
    }

    private static void insertionSortAdhoc(int[] arr, int n) {
        for (int i = 1; i < n ;i++){
            int key = arr[i];
            int j = i-1;
            while (j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            System.out.print(j + 1 + " ");
            arr[j+1] = key;
        }
    }
}
