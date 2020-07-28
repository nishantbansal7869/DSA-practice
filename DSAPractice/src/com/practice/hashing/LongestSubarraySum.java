package com.practice.hashing;


import java.util.HashMap;

public class LongestSubarraySum {
    public static void main(String[] args) {
        int[] arr = {1,9,-4,-4,9,2,2};
        int sum = 0;
        int length = longestSubarray(arr,sum);
        System.out.print(length);
    }

    private static int longestSubarray(int[] arr, int sum) {
        int length = 0;
        HashMap<Integer, Integer> map = new HashMap<>(arr.length);
        int preSum = 0;
       for(int i = 0; i < arr.length; i++){
            int temp = 0;
            preSum += arr[i];
            if(map.containsKey(preSum - sum)){
                temp = i - map.get(preSum-sum);
            }
            else {
                map.put(preSum,i);
            }
            if(preSum == sum){
                temp = i + 1;
            }
            length = Math.max(length,temp);
        }
        return length;
    }
}
