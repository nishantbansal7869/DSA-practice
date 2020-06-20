package com.practice.sorting;

import java.util.Arrays;

public class SortingUsingHoarePartition {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,5,4,1,6,9,8};
        quickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void quickSort(int arr[], int l, int h){
        if(l < h){
            int p = partition(arr,l,h);
            quickSort(arr,l,p);
            quickSort(arr,p+1,h);
        }
    }
    public static int partition(int arr[], int l, int h){
        int i = l-1;
        int j = h+1;
        int pivot= arr[l];
        while (true){
            do{
                i++;
            }while (arr[i] < pivot);
            do{
                j--;
            }while (arr[j] > pivot);
            if( i >= j ) return j;
            swap(arr,i,j);
        }
    }

    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
