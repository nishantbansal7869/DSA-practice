package com.practice.searching;

public class MissingAndRepeating {
    public static void main(String[] args) {
        int arr[] = new int[]{2,3,4,5,5};
        repeatingAndMissing(arr,arr.length);
    }
    public static void repeatingAndMissing(int arr[], int n){
        int repeating = 0;
        int missing = 0;
        for(int i = 0; i < n; i++){
            int temp = arr[Math.abs(arr[i])-1];
            if(temp < 0)
            {
                repeating = Math.abs(arr[i]);
            }
            arr[Math.abs(arr[i])-1] = - arr[Math.abs(arr[i]) -1];
        }
        for(int i = 0; i < n; i++){
            if(arr[i]>0)
                missing = i;
        }
    System.out.println(repeating + " " + missing);
    }


}
