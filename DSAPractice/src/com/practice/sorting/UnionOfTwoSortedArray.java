package com.practice.sorting;

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{4,4};
        int arr2[] = new int[]{2,3,3,3,3,3,3,4};
        union(arr1,arr2,arr1.length,arr2.length);
    }
    public static void union(int arr1[], int arr2[], int n, int m){
        int i = 0; int j = 0;
        while (i < n && j < m){
            if(i > 0 && arr1[i] == arr1[i-1]){
                i++;
                continue;
            }
            if(j > 0 && arr2[j] == arr2[j-1]){
                j++;
                continue;
            }
            if(arr1[i] < arr2[j]){
                System.out.println(arr1[i]);
                i++;
            }
            else if(arr2[j] < arr1[i]){
                System.out.println(arr2[j]);
                j++;
            }
            else if (arr1[i] == arr2[j]){
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
        while (i < n){
           if(i > 0 && arr1[i] == arr1[i-1]){
               i++;
               continue;
           }
           else {
               System.out.println(arr1[i]);
               i++;
           }
        }
        while (j < m){
            if(j > 0 && arr2[j] == arr2[j-1]){
                j++;
                continue;
            }
            else {
                System.out.println(arr2[j]);
                j++;
            }
        }
    }
}
