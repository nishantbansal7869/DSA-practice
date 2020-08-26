package com.practice.interviewbit;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        quickSort(arr, 0, n-1);
        Arrays.stream(arr).forEach(i->System.out.println(i));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low >= high)
            return;
        int p = partition(arr, low, high);
        quickSort(arr, low, p-1);
        quickSort(arr, p+1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low-1;
        for (int j = low; j < high; j++){
            if (arr[j] < pivot){
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i+1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int high) {
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
    }
}
