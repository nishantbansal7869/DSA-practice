package com.practice.sorting;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = new int[]{3,2,1,6,5,7,8};
        mergeSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(s->System.out.println(s));
    }
    public static void mergeSort(int[] arr, int l, int r){
        if(r>l){
            int m = (l+r)/2;
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
    public static void merge(int[] arr, int l, int m ,int r){
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
           if(larr[i] <= rarr[j]){
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
