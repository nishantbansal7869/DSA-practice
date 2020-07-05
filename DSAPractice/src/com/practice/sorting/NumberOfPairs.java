package com.practice.sorting;

import sun.nio.cs.ext.MacArabic;

import java.util.Arrays;


public class NumberOfPairs {
    public static void main(String[] args) {
        int arr1[] = new int[]{2,3,4,5};
        int arr2[] = new int[]{1,2,3};
        long count =  numberOfPairs(arr1,arr2,arr1.length,arr2.length);
        System.out.print(count);
    }
    static long numberOfPairs(int[] arr1, int[] arr2, int n, int m){
       long count = 0;
       int noOfY[] = new int[5];
       for(int i = 0; i < m ;i++){
           if(arr2[i] < 5){
               noOfY[arr2[i]]++;
           }
       }
       Arrays.sort(arr2);
       for(int i = 0; i < n; i++){
           count += countPairs(arr1[i],arr2,m,noOfY);
       }
       return count;
    }

    static long countPairs(int x, int[] arr2, int m, int[] noOfY){
        if(x == 1){
            return 0;
        }
        int index = Arrays.binarySearch(arr2,x);
        long ans = 0;
        if(index < 0){
            index = Math.abs(index+1);
            ans = m - index;
        }
        else {
            while (index < m && arr2[index] == x){
                index++;
            }
            ans = m - index;
        }
        ans += noOfY[1];
        if(x == 2){
            ans -= (noOfY[3] + noOfY[4]);
        }
        if(x == 3){
            ans += noOfY[2];
        }
        return ans;
    }

}
