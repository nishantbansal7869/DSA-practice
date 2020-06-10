package com.practice.arrayQuestions;

public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{1,3,4,10};
        int arr2[] = new int[]{2,5,7,8};
        mergeArray(arr1,arr2,arr1.length,arr2.length);
    }
    public static void mergeArray(int arr1[], int arr2[], int n, int m){
        int arr3[] = new int[n+m];
        int i = 0, j = 0, k =0;
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                arr3[k] = arr1[i];
                i++;
                k++;
            }
            else {
                arr3[k] = arr2[j];
                j++;
                k++;
            }
        }
        while(i < n){
            arr3[k] = arr1[i];
            k++;
            i++;
        }
        while(j < m){
            arr3[k] = arr2[j];
            k++;
            j++;
        }
        for(int l = 0; l < arr3.length; l++){
            System.out.println(arr3[l]);
        }
    }
}
