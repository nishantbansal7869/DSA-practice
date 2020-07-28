package com.practice.hashing;

import java.util.HashSet;

public class PairWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {3,2,8,15,-8};
        int n = arr.length;
        int k = 16;
        boolean present = paitWithsum(arr, n, k);
        System.out.print(present);
    }

    private static boolean paitWithsum(int[] arr, int n, int k) {
        HashSet<Integer> set = new HashSet<>(n);
        for(int i = 0; i < n; i++){
            if(set.contains(k - arr[i])){
                return true;
            }
            else {
                set.add(arr[i]);
            }
        }
        return false;
    }
}
