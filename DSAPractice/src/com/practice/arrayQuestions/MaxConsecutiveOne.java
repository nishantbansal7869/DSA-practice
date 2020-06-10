package com.practice.arrayQuestions;

public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int arr[] = new int[]{0,1,1,1,1,0,0,1,1,1,1,1,1,0};
        System.out.println(maxOne(arr,arr.length));
    }
    public static int maxOne(int arr[], int n){
        int res = 0;
        int cur = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == 0){
                cur = 0;
            }
            else {
                cur++;
                res = Math.max(res,cur);
            }
        }
        return res;
    }
}
