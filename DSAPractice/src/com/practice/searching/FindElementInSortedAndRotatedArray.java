package com.practice.searching;

public class FindElementInSortedAndRotatedArray {
    public static void main(String[] args) {
        int arr[] = new int[]{10,20,40,50,3,6,7,8};
        int x = 8;
        int maxElementIndex = maxElement(arr,0,arr.length-1);
        int leftSearch = binarySearch(arr,0,maxElementIndex,x);
        int rightSearch = binarySearch(arr,maxElementIndex+1,arr.length-1,x);
        if(leftSearch == -1 && rightSearch == -1)
            System.out.println("-1");
        else if(leftSearch == -1)
            System.out.println(rightSearch);
        else
            System.out.println(leftSearch);
    }
    public static int maxElement(int arr[], int low, int high){
        if(low > high)
            return -1;
        if (high == low)
            return low;
        int mid = (low+high)/2;
        if (mid < high && arr[mid] > arr[mid + 1])
            return mid;
        if (mid > low && arr[mid] < arr[mid - 1])
            return (mid-1);
        if(arr[mid] <= arr[low])
            return maxElement(arr,low,mid-1);
        else
            return maxElement(arr,mid+1,high);

    }
    public static int binarySearch(int arr[], int low, int high, int x){
        if(low > high)
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
