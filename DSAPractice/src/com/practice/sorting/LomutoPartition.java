package com.practice.sorting;

import java.util.Arrays;

public class LomutoPartition {
    public static void main(String[] args) {
        int arr[] = new int[]{70,60,20,10,40,50,30};
        lomutoPartition(arr,arr.length);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void lomutoPartition(int arr[], int n){
        int l = 0;
         int h = n-1;
         int pivot = arr[h];
         int i = l-1;
         for(int j = 0; j <= h-1; j++){
             if(arr[j] < pivot){
                 i++;
                 swap(arr,i,j);
             }
         }
         swap(arr,i+1,h);
    }
    public static void swap(int[] arr, int l, int h ){
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
}
