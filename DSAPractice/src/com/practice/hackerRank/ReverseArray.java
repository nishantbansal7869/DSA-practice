package com.practice.hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int l = 0;
        int r = n-1;
        int arr[] = new int[n];
        for(int i = 0; i < n;i++){
            arr[i] = sc.nextInt();
        }
        reverseArray(arr,n,l,r);
        Arrays.stream(arr).forEach(s->System.out.print(s + " "));
    }
    public static void reverseArray(int[] arr, int n, int l, int r){
        if(l < r){
            swap(arr,l,r);
            reverseArray(arr,n,l+1,r-1);
        }
    }
    public static void swap(int[] arr, int l, int r){
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

}
