package com.practice.recurssionQuestions;

import java.util.Arrays;

public class SubsetOfArray {
    public static void main(String[] args) {
        int arr[] = new int[]{1,5,11,5};
        int sum = 5;
        int totalSum = Arrays.stream(arr).sum();
        System.out.println(subset(arr,arr.length,0,totalSum));
    }
    public static int subset(int arr[], int n, int sum, int totalSum){
        if(n==0){
            return (sum == totalSum-sum)?1:0;
        }
        return subset(arr,n-1,sum,totalSum)+subset(arr,n-1,sum+arr[n-1],totalSum);
    }
}
