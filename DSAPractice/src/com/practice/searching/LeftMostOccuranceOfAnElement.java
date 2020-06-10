package com.practice.searching;

public class LeftMostOccuranceOfAnElement {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,3,3,3};
        System.out.println(leftMostOccurance(arr,0,arr.length-1,3));
    }
    public static int leftMostOccurance(int arr[], int low, int high, int x){
        if(low > high)
            return -1;
        int mid = (low+high)/2;
        if(arr[mid] == x && (mid == 0 || arr[mid-1] != x))
        {
                return mid;
        }
        if(arr[mid]>=x){
            return leftMostOccurance(arr,low,mid-1,x);
        }
        else
            return leftMostOccurance(arr,mid+1,high,x);

    }
}
