package com.practice.arrayQuestions;

public class TrappingRainWater {
    public static void main(String[] args) {
        int arr[] = new int[]{5,0,6,8,3};
        System.out.println(water(arr,arr.length));
    }
    public static int water(int arr[], int n){
        int lmax[] = new int[n];
        lmax[0] = arr[0];
        for(int i = 1; i < n; i++){
            lmax[i] = Math.max(lmax[i-1],arr[i]);
        }
        int rmax[] = new int[n];
        rmax[n-1] = arr[n-1];
        for(int i = n-2; i >=0; i--){
            rmax[i] = Math.max(rmax[i+1],arr[i]);
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            res += (Math.min(lmax[i],rmax[i]) - arr[i]);
        }
        return res;
    }
}
