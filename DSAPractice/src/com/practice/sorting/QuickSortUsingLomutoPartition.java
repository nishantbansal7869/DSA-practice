package com.practice.sorting;

import java.util.Arrays;

/*
* To improve the quick sort time complexity instead of taking first or last element as pivot element we
* select a random index between l and h as a pivot and swap it with first or last index based on partition
* being used and then apply quick sort. In this way time complexity becomes O(n log n)
* */


public class QuickSortUsingLomutoPartition {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,5,4,1,6,9,8,7};
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void quickSort(int[] arr, int l, int h){
        if(h > l){
            int p = partition(arr,l,h);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,h);
        }
    }
    public static int partition(int[] arr, int l ,int h){
        int pivot = arr[h];
        int i = l-1;
        for(int j = l; j <= h-1; j++){
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr,i+1,h);
        return i+1;
    }
    public static void swap(int[] arr, int l, int h){
        int temp = arr[l];
        arr[l] = arr[h];
        arr[h] = temp;
    }
}
