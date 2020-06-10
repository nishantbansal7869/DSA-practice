package com.practice.searching;

public class PeakElement {
    public static void main(String[] args) {
        int arr[] = new int[]{26,20,5,3,79,80,97};
        int peakIndex = peakElement(arr,0,arr.length-1);
        System.out.println(arr[peakIndex]);
    }
    public static int peakElement(int arr[], int low, int high){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if((mid==0 || arr[mid] >= arr[mid-1]) &&
                (mid == arr.length-1 || arr[mid] >= arr[mid+1] ))
            return mid;
        if(mid > 0 && arr[mid-1] > arr[mid])
            return peakElement(arr,low,mid-1);
        else
            return peakElement(arr,mid+1,high);
    }
}

