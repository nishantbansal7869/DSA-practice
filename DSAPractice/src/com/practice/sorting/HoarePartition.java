package com.practice.sorting;

import java.util.Arrays;

public class HoarePartition {
    public static void main(String[] args) {
        int arr[] = new int[]{2,0,1,4,5,6,7};
        System.out.println(hoarePartition(arr,arr.length));
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static int hoarePartition(int arr[], int n){
        int pivot = arr[0];
        int l = 0;
        int h = n-1;
        int i = l-1;
        int j = h+1;
        while (true){
            do{
                i++;
            }while (arr[i] < pivot);
            do{
                j--;
            }while (arr[j] > pivot);
            if(i >= j) return j;
            swap(arr,i,j);
        }
    }
    public static void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
