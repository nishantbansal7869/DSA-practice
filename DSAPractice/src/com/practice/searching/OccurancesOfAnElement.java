package com.practice.searching;

public class OccurancesOfAnElement {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,3,3,3,4,5,6};
        int leftMostOccur = leftmostOccurance(arr,0,arr.length-1,4);
        int rightMostOccur  = rightMostOccurance(arr,0,arr.length-1,4,arr.length);
        System.out.println((rightMostOccur-leftMostOccur)+1);
    }
    public static int leftmostOccurance(int arr[], int low, int high, int x){
        if(low>high)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] == x && (mid == 0 || arr[mid-1] != x))
            return mid;
        if(arr[mid] >= x)
            return leftmostOccurance(arr,low,mid-1,x);
        else
            return leftmostOccurance(arr,mid+1,high,x);
    }
    public static int rightMostOccurance(int arr[], int low, int high, int x, int n){
        if(low> high)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] == x && (mid == (n-1) || arr[mid+1] != x))
            return mid;
        if(arr[mid]>x)
            return rightMostOccurance(arr,low,mid-1,x,n);
        else
            return rightMostOccurance(arr,mid+1,high,x,n);
    }
}
