package com.practice.hashing;

import java.util.HashMap;

public class LongestSubarrayWithEqual0And1 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,1,1,1,0,0,0};
        int sum = 0;
        int count = longest(arr, sum);
        System.out.print(count);
    }

    private static int longest(int[] arr, int sum) {
        int preSum = 0;
        int length = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 0){
                arr[i] = -1;
            }
        }
        for (int i = 0; i < arr.length; i++){
            preSum += arr[i];
            int temp = 0;
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
