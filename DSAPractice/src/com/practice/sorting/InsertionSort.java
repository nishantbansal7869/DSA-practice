package com.practice.sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = new int[]{-20 ,-3916237, -357920, -3620601, 7374819, -7330761 ,30 ,6246457, -6461594, 266854, -520, -470  };
        int count = insertionSort(arr,arr.length);
        Arrays.stream(arr).forEach(s->System.out.println(s));
        System.out.print("Count: " + count);
    }
    public static int insertionSort(int[] arr, int n){
        int count = 0;
        for(int i = 1; i < n; i++){
            int key = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j]>key){
                count++;
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return count;
    }
}
