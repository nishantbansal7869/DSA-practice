package com.practice.sorting;

import java.util.Arrays;

//dutch national flag algorithm

public class SortAnArrayWithThreeTypes {
    public static void main(String[] args) {
        int arr[] = new int[]{1,1,0,0,2,1,2,0,1,2,2,0};
        sortArray(arr,arr.length);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void sortArray(int arr[], int n){
        int low = 0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            switch (arr[mid]){
                case 0: swap(arr,low,mid);
                low++;
                mid++;
                break;
                case 1: mid++;
                break;
                case 2: swap(arr,mid,high);
                high--;
                break;
            }
        }
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
