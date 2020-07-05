package com.practice.sorting;

import java.util.ArrayList;

public class MergeThreeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = new int[]{1,2,3};
        int[] arr2 = new int[]{2,3,4,5};
        int[] arr3 = new int[]{3,4,5,6};
        ArrayList<Integer> list = merge(arr1,arr2,arr3,arr1.length,arr2.length,arr3.length);
        System.out.print(list);
    }
    static ArrayList<Integer> merge(int[] arr1, int[] arr2, int[] arr3, int n, int m, int p){
        ArrayList<Integer> list = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < n && j < m && k < p){
            int a = arr1[i];
            int b = arr2[j];
            int c = arr3[k];
            if(a <= b && a <= c){
                list.add(a);
                i++;
            }
            else if(b <= a && b <= c){
                list.add(b);
                j++;
            }
            else {
                list.add(c);
                k++;
            }
        }
        while (i < n && j < m){
            if(arr1[i] <= arr2[j]){
                list.add(arr1[i]);
                i++;
            }
            else {
                list.add(arr2[j]);
                j++;
            }
        }
        while (i < n && k < p){
            if(arr1[i] <= arr3[k]){
                list.add(arr1[i]);
                i++;
            }
            else {
                list.add(arr3[k]);
                k++;
            }
        }
        while (j < m && k < p){
            if(arr2[j] <= arr3[k]){
                list.add(arr2[j]);
                j++;
            }
            else {
                list.add(arr3[k]);
                k++;
            }
        }
        while (i < n){
            list.add(arr1[i]);
            i++;
        }
        while (j < m){
            list.add(arr2[j]);
            j++;
        }
        while (k < p){
            list.add(arr3[k]);
            k++;
        }
        return list;
    }
}
