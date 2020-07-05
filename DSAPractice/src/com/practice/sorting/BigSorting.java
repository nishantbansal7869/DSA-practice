package com.practice.sorting;

import java.math.BigInteger;

public class BigSorting {
    public static void main(String[] args) {
        String[] unsorted = new String[]{"31415926535897932384626433832795", "1","3","5","3","4"};
        String[] sorted = mergeSorting(unsorted, 0, unsorted.length-1);
        for(int i = 0; i < sorted.length; i++){
            System.out.println(sorted[i]);
        }
    }

    private static String[] mergeSorting(String[] unsorted, int i, int i1) {
        mergeSort(unsorted, i, i1);
        return unsorted;
    }

    private static void mergeSort(String[] unsorted, int low, int high) {
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(unsorted,low,mid);
            mergeSort(unsorted,mid+1,high);
            merge(unsorted,low,mid,high);
        }
    }

    private static void merge(String[] unsorted, int low, int mid, int high) {
        int n1 = mid-low+1;
        int n2 = high-mid;
        String[] larr = new String[n1];
        String[] rarr = new String[n2];
        for(int i = 0; i < n1 ; i++){
            larr[i] = unsorted[low+i];
        }
        for(int j = 0; j < n2; j++){
            rarr[j] = unsorted[mid+1+j];
        }
        int i = 0;
        int j = 0;
        int k = low;
        while (i < n1 && j < n2){
            BigInteger A = new BigInteger(larr[i]);
            BigInteger B = new BigInteger(rarr[j]);
            if(A.compareTo(B) <= 0){
                unsorted[k++] = larr[i++];
            }
            else {
                unsorted[k++] = rarr[j++];
            }
        }
        while (i < n1){
            unsorted[k++] = larr[i++];
        }
        while (j  <n2){
            unsorted[k++] = rarr[j++];
        }
    }
}
