package com.practice.searching;

public class MaximumWater {
    public static void main(String[] args) {
        int arr[] = new int[]{2,1};
        System.out.println(maxWater(arr,arr.length));
    }
    public static int maxWater(int arr[], int n){
        int maxWater = 0;
       int water = 0;
        int i = 0;
        int j = n-1;
        while(i < j){
            if(arr[i] < arr[j]){
                water = arr[i] * (j-i-1);
                maxWater = Math.max(water,maxWater);
                i++;
            }
            else {
                water = arr[j] * (j-i-1);
                maxWater = Math.max(water,maxWater);
                j--;
            }
        }
    return maxWater;
    }
}
