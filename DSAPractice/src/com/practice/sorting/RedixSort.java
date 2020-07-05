package com.practice.sorting;

import java.util.Arrays;

public class RedixSort {
    public static void main(String[] args) {
        int arr[] = new int[]{319,100,5,8,90,50};
        redixSort(arr,arr.length);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void redixSort(int[] arr, int n){
        int max = arr[0];
        for(int i = 0; i < n; i++){
            if(arr[i]>max){
                max = arr[i];
            }
        }
        for(int exp = 1; max/exp > 0; exp *= 10 ){
            countSort(arr,arr.length,exp);
        }
    }
    public static void countSort(int[] arr, int n, int exp){
        int[] count = new int[10];
        int output[] = new int[n];
        for(int i = 0; i < n; i++){
            count[(arr[i]/exp)%10]++;
        }
        for(int i = 1; i < 10; i++){
            count[i] = count[i-1]+count[i];
        }
        for(int i = n-1; i >= 0; i--){
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }
        for(int i = 0; i < n; i++){
            arr[i] = output[i];
        }
    }
}
