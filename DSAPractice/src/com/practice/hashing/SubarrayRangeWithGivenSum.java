package com.practice.hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class SubarrayRangeWithGivenSum {
    public static void main(String[] args) {
        int[] arr = {12, 20, };
        int n = arr.length;
        int sum = -10;
        int count = subArrayWithSum(arr, n, sum);
        System.out.println(count);
    }

    private static int subArrayWithSum(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            prefixSum += arr[i];
            if(prefixSum == sum)
                count++;
            if(map.containsKey(prefixSum - sum)){
                count += map.get(prefixSum-sum);
            }
            Integer curr = map.get(prefixSum);
            if(curr == null){
                map.put(prefixSum, 1);
            }
            else {
                map.put(prefixSum, ++curr);
            }
        }
        return count;
    }
}
