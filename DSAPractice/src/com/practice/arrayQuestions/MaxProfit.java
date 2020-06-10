package com.practice.arrayQuestions;

public class MaxProfit {
    public static void main(String[] args) {
        int arr[] = new int[]{1,5,3,8,12};
        System.out.println(maxProfit(arr,arr.length));
    }
    public static int maxProfit(int arr[], int n){
        int profit = 0;
        for(int i = 1; i < n; i++){
            if(arr[i]>arr[i-1]){
                profit += (arr[i]-arr[i-1]);
            }
        }
        return profit;
    }

}
