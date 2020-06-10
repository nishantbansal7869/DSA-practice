package com.practice.searching;

public class BinarySearchInAnInfiniteSizedArray {
    public static void main(String[] args) {
        int arr[] = new int[]{0,1,20,40,80,90,100,120,140};
       System.out.println( lookForIndexGreaterThanElementToBeSearched(arr,100));
    }
    public static int lookForIndexGreaterThanElementToBeSearched(int arr[], int x){
        if(arr[0] == x)
            return 0;
        int i = 1;
        while (arr[i]<x)
            i *= 2;
        if(arr[i] == x)
            return i;
        return binarySearch(arr,i/2,i,x);
    }
    public static int binarySearch(int arr[],int low,int high,int x){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] == x)
            return mid;
        if(arr[mid] > x)
            return binarySearch(arr,low,mid-1,x);
        else
            return binarySearch(arr,mid+1,high,x);
    }
}
