package com.practice.hashing;

import java.util.Hashtable;

public class CountDistinctElementInEveryWindow {
    public static void main(String[] args) {
        int[] arr = {10,20,30,40};
        int k = 3;
        int n = arr.length;
        countDistinctElement(arr,n,k);
    }

    private static void countDistinctElement(int[] arr, int n, int k) {
        if(k >= n){
            return;
        }
        Hashtable<Integer,Integer> table = new Hashtable<>(n);
        for(int i = 0; i < k; i++){
           if(table.containsKey(arr[i])){
               int count = table.get(arr[i]);
               table.put(arr[i],++count);
           }
           else {
               table.put(arr[i],1);
           }
        }
        System.out.println(table.size());
        for(int i = 1; i < n-k+1; i++){
            //if(table.containsKey(arr[i-1])) {
                int count = table.get(arr[i - 1]);
                if (count == 1) {
                    table.remove(arr[i - 1]);
                } else {
                    table.put(arr[i - 1], --count);
                }
           // }
            if(table.containsKey(arr[i+k-1])){
                 count = table.get(arr[i+k-1]);
                table.put(arr[i+k-1],++count);
            }
            else {
                table.put(arr[i+k-1],1);
            }
            System.out.println(table.size());
        }
    }
}
