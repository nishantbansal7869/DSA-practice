package com.practice.hashing;

import java.util.HashSet;

public class SubArrayWithSum0 {
    public static void main(String[] args) {
        int[] arr = {1,1,13,3,10,5};
        int n = arr.length;
        boolean present = prefix(arr,n);
        System.out.print(present);
    }

    private static boolean prefix(int[] arr, int n) {
        HashSet<Integer> set = new HashSet<>(n);
        int preSum = 0;
        for(int i : arr){
            preSum += i;
            if(set.contains(preSum)){
                return true;
            }
            else {
                set.add(preSum);
            }
            if(preSum == 0){
                return true;
            }
        }
        return false;
    }

}
