package com.practice.searching;

public class MinimumElement {
    public static void main(String[] args) {
        int arr[] = new int[]{10,20,30};
        System.out.println(minEl(arr,0,arr.length-1));
    }
    public static int minEl(int arr[], int low, int high){
        while(low <= high){
            if(low == high && arr[high] > arr[0]){
                return arr[0];
            }
            int mid = (low+high)/2;
            if (mid < high && arr[mid] > arr[mid + 1])
                return arr[mid+1];
            if (mid > low && arr[mid] < arr[mid - 1])
                return arr[mid];
            if(arr[mid] <= arr[low])
                high = mid - 1;
            else
                low = mid + 1;

        }
        return -1;
    }
}
