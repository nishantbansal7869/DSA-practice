package com.practice.searching;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = new int[]{11,8,2,50,90};
        Arrays.sort(arr);
        System.out.println(binarySearch(arr,0,arr.length-1,8));
    }
    public static int binarySearch(int arr[], int low,int high,int x){
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] == x)
            return mid;
        if(arr[mid]>x){
            return binarySearch(arr,low,mid-1,x);
        }
        else
            return binarySearch(arr,mid+1,high,x);
    }


}
