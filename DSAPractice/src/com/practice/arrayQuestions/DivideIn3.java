package com.practice.arrayQuestions;

public class DivideIn3 {
    public static void main(String[] args) {
        int arr[] = new int[]{0,0,7,0,5,1,6};
        System.out.println(divide3(arr,arr.length));
    }
    public static boolean divide3(int arr[], int n){
       int sum = 0;
       int count = 0;
       for(int i = 0; i < n; i++){
           sum += arr[i];
       }
       int div = sum/3;
       for(int i =0; i < n; i++){
           if(arr[i] == 0)
               continue;
           if((sum-arr[i])%div == 0){
               count++;
           }
           sum -= arr[i];
       }
       if(count == 3){
           return true;
       }
       return false;
    }
}
