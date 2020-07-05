package com.practice.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[]{10,5,3,9,2};
        int k = 7;
        mergeSort(arr,0,arr.length-1, k);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void mergeSort(int[] arr, int l, int r, int k){
        if(r>l){
            int m = (l+r)/2;
            mergeSort(arr,l,m,k);
            mergeSort(arr,m+1,r,k);
            merge(arr,l,m,r,k);
        }
    }
    public static void merge(int[] arr, int l, int m ,int r, int p){
       int n1 = m-l+1;
       int n2 = r-m;
       int larr[] = new int[n1];
       int rarr[] = new int[n2];
       for(int i = 0; i < n1; i++){
           larr[i] = arr[l+i];
       }
       for(int j = 0; j < n2; j++){
           rarr[j] = arr[m+1+j];
       }
       int i = 0;
       int j = 0;
       int k = l;
       while(i < n1 && j < n2){
           if(Math.abs(p-larr[i]) <= Math.abs(p-rarr[j])){
               arr[k++] = larr[i++];
           }
           else {
               arr[k++] = rarr[j++];
           }
       }
       while (i < n1){
           arr[k++] = larr[i++];
       }
       while (j < n2){
           arr[k++] = rarr[j++];
       }
    }
}
