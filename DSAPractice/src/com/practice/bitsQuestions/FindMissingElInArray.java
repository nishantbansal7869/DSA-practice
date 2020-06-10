package com.practice.bitsQuestions;

public class FindMissingElInArray {
    public static void main(String[] args) {
        int arr[] =  new int[]{1,2,4,5,6,7};
       System.out.println(missingEl(arr,6));
    }

    public static int missingEl(int ar[] , int n){
        int res = 0;
        for(int i = 1; i <= n+1; i++){
            res = res ^ i;
        }
        int res2 = 0;
        for(int i = 0; i< n ; i++){
            res2 = res2 ^ ar[i];
        }

        return res ^ res2;
    }
}
