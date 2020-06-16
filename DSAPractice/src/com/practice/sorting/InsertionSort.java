package com.practice.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{3,1,4,2,6,5,8,9};
        insertionSort(arr,arr.length);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void insertionSort(int[] arr, int n){
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}
