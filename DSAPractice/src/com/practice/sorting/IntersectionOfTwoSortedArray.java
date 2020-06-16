package com.practice.sorting;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int arr1[] = new int[]{2,5,8,8,13,13,15,15};
        int arr2[] = new int[]{1,3,8,8,15,15,18,20};
        intersection(arr1,arr2,arr1.length,arr2.length);
        }
        public static void intersection(int[] arr1, int[] arr2, int n, int m){
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
                i++;
            }
            else if(arr2[j] < arr1[i]){
                j++;
            }
            else if(arr1[i] == arr2[j]){
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }
}
