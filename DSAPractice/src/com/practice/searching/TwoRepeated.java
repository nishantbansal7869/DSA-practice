package com.practice.searching;

public class TwoRepeated {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2,1};
        twoRepeated(arr,arr.length);
    }
    public static void twoRepeated(int arr[], int n){
        int repeating[] = new int[2];
        int j = 0;
        for(int i = 0; i < n; i++){
            int temp = arr[Math.abs(arr[i])-1];
            if(temp < 0){
                repeating[j] = Math.abs(arr[i]);
                j++;
            }
            arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) -1 ];
        }
        for(int i = 0; i < 2; i++)
            System.out.println(repeating[i]);
    }
}
