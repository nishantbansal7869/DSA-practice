package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class TripleTroubleUsingMergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
            mergeSort(arr, 0, n-1);
            int element = findNonrepeating(arr, n);
            System.out.println(element);
            test--;
        }
    }

    private static int findNonrepeating(int[] arr, int n) {
        int count = 1;
        int i;
        for ( i = 0; i < n-1; i++){
            if (arr[i+1] == arr[i]){
                count++;
            }
            else {
                if (count % 3 == 0){
                    count = 1;
                    continue;
                }
                else
                    return arr[i];
            }
        }
        return arr[i];
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = (low+high)/2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low, high);
    }

    private static void merge(int[] arr, int low, int high) {
        int mid = (low+high)/2;
        int[] temp = new int[high- low + 1];
        int p1 = low, p2 = mid + 1, k = 0;
        while (p1 <= mid && p2 <= high){
            if (arr[p1] > arr[p2] ){
                temp[k++] = arr[p2++];
            }
            else {
                temp[k++] = arr[p1++];
            }
        }
        while (p1 <= mid)
            temp[k++] = arr[p1++];
        while (p2 <= high)
            temp[k++] = arr[p2++];
        for (int i = 0; i < k; i++)
            arr[low+i] = temp[i];
    }
}
