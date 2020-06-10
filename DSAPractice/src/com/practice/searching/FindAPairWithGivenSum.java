package com.practice.searching;

public class FindAPairWithGivenSum {
    public static void main(String[] args) {
        int arr[] = new int[]{2,5,8,12,30};
        findAPairWithGivenSum(arr,arr.length,2222);
    }
    public static void findAPairWithGivenSum(int arr[], int n, int x){
        int low = 0;
        int high = n-1;
        while (low < high){
            if(arr[low] + arr[high] == x) {
                System.out.println(arr[low] + " " + arr[high]);
                return;
            }
            if(arr[low]+arr[high] > x)
                high--;
            else
                low++;
        }
        System.out.println("not found");
    }
}
