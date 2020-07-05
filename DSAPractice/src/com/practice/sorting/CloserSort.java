package com.practice.sorting;

public class CloserSort {
    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,3};
        long x = 5;
        long index = closerSort(arr, arr.length, x);
        System.out.print(index);
    }
    static long closerSort(int[] arr, int n, long x){
        int index = search(arr,0,n-1,x);
        return index;
    }
    static int search(int[] arr, int low, int high, long x){
        if(low > high){
            return -1;
        }
        int mid = (low+high)/2;
        if(arr[mid] == (int)x)
            return mid;
        else if(mid > 0 && arr[mid-1] == (int)x)
            return mid - 1;
        else if(mid < arr.length-1 && arr[mid+1]==(int)x)
            return mid+1;
        if(arr[mid] > (int)x && (mid == arr.length-1 || arr[mid+1] > (int)x))
            return search(arr,low,mid-1,x);
        else
            return search(arr,mid+1,high,x);
    }
}
