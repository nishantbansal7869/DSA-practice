package com.practice.hackerRank;

import java.util.Scanner;

public class TripleTrouble {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while(test > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0; i < n; i++){
                arr[i] = sc.nextInt();
            }
            int singleEl = singleOccurringElement(arr,n);
            System.out.println(singleEl);
            test--;
        }
    }
    static int singleOccurringElement(int[] arr, int n){
        int count1 = 0;
        int count0 = 0;
        int num = 0;
        for(int i = 0; i < 31; i++){
            for(int a : arr){
                if(checkBit(a,i) > 0)
                    count1++;
                else
                    count0++;
            }
            if(count1 % 3 != 0){
                num = num | (1<<i);
            }
            count0 = 0;
            count1 = 0;
        }
        return num;
    }

    static int checkBit(int a, int i){
        return a&(1<<i);
    }
}
