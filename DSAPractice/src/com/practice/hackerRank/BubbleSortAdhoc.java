package com.practice.hackerRank;

import java.util.Scanner;

public class BubbleSortAdhoc {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int swaps = bubbleSort(arr,n);
            System.out.println(swaps);
            test--;
        }
    }

    private static int bubbleSort(int[] arr, int n) {
        int count = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n-i-1; j++){
                if (arr[j] > arr[j+1]){
                    count++;
                    swapEl(arr,j,j+1);
                }
            }
        }
        return count;
    }

    private static void swapEl(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }
}
