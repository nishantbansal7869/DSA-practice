package com.practice.hashing;

import java.util.HashMap;

public class LongestCommonSpanWithSameSumInTwoArrays {
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,0,0,0};
        int[] arr2 = {1,0,1,0,0,1};
        int temp[] = new int[arr1.length];
        for(int i = 0; i < arr1.length; i++){
            temp[i] = arr1[i] - arr2[i];
        }
        int length = longestSum(temp, 0);
        System.out.print(length);
    }

    private static int longestSum(int[] arr, int sum) {
        int preSum = 0;
        int length = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

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
