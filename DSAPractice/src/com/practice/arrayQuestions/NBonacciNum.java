package com.practice.arrayQuestions;

public class NBonacciNum {
    public static void main(String[] args) {
        printNbonacci(4,10);
    }
    public static void printNbonacci(int n, int m){
        int arr[] = new int[m];
        arr[n-1] = 1;
        arr[n] = 1;
        int sum = 1;
        for(int i = n+1; i < m; i++){
            sum = sum - arr[i-n -1] + arr[i-1];
            arr[i] = sum;
        }
        for(int  i = 0; i < m; i++){
            System.out.println(arr[i]);
        }
    }
}
