package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class SelectionSortAdhoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            selectionSort(arr,n);
            test--;
        }
    }

    private static void selectionSort(int[] arr, int n) {
        for (int i = n-1; i > 0; i--){
            int maxIndex = i;
            for (int j = i-1; j >= 0; j--){
                if (arr[j] > arr[maxIndex])
                    maxIndex = j;
            }
            swaparr(arr, maxIndex, i);
            System.out.print(maxIndex + " ");
        }
        System.out.println();
    }

    private static void swaparr(int[] arr, int minIndex, int i) {
        int temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}
