package com.practice.sorting;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int arr[] = new int[]{5,4,5,6};
        int k = 7;
        int count[] = new int[k];
        int output[]= new int[arr.length];
        countSort(arr,arr.length,k,count,output);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void countSort(int[] arr, int n, int k, int[] count, int[] output){
        for (int i = 0; i < n; i++){
            count[arr[i]]++;
        }
        for (int i = 1; i < k; i++){
            count[i] = count[i-1]+count[i];
        }
        for (int i = n-1; i >= 0; i--){
            output[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        for (int i = 0 ; i < n; i++){
            arr[i] = output[i];
        }
    }
}
