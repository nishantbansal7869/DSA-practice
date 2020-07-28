package com.practice.hashing;

import java.util.HashSet;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {5,8,6,1,1,-1};
        int sum = 0;
        boolean present = prefix(arr, sum);
        System.out.print(present);
    }

    private static boolean prefix(int[] arr, int sum) {
        HashSet<Integer> set = new HashSet<>();
        int preSum = 0;
        for (int i : arr){
            preSum += i;
            if(set.contains(preSum - sum))
                return true;
            else
                set.add(preSum);
            if(preSum == sum)
                return true;
        }
        return false;
    }
}
