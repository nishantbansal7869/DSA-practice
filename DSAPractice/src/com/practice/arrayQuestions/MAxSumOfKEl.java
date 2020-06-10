package com.practice.arrayQuestions;

public class MAxSumOfKEl {
    public static void main(String[] args) {
        int arr[] = new int[]{1,8,30,-5,20,7};
        System.out.println(maxEl(arr,arr.length,3));
    }
    public static int maxEl(int arr[], int n,int k){
        int max_sum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i < k; i++){
            sum += arr[i];
        }
        max_sum = Math.max(sum,max_sum);
        for(int i = k; i < n; i++){
            sum = sum - arr[i-k] + arr[i];
            max_sum = Math.max(sum,max_sum);
        }
        return max_sum;
    }
}
