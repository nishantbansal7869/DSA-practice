package com.practice.backtrackingQuestion;

import java.util.Arrays;

public class PartitionToKEqualSum {
    public static void main(String[] args) {
        int arr[] = new int[]{-5,-2,-3,-3,-3};
        boolean used[] = new boolean[arr.length];
        int k = 2;
        System.out.println(partition(0,arr,used,k));
    }
    public static boolean partition(int start, int arr[], boolean used[], int k){
        int arrSum = Arrays.stream(arr).sum();
        if(k == 0 || arrSum % k != 0){
            return false;
        }
        int targetSum = arrSum / k;
        return partitionIs(start, arr, used, k, 0, targetSum);
    }
    public static boolean partitionIs(int start, int arr[], boolean used[], int k, int sum, int targetSum){
        if(k == 1){
            return true;
        }
        if(targetSum == sum){
            return partitionIs(0,arr,used,k-1,0,targetSum);
        }
        for(int i = start; i < arr.length; i++){
            if(!used[i]){
                used[i] = true;
                if(isSafe(sum+arr[i],targetSum)){
                    if(partitionIs(i+1,arr,used,k,sum+arr[i],targetSum)){
                        return true;
                    }
                }
                used[i] = false;
            }
        }
        return false;
    }
    public static boolean isSafe(int sum, int targetSum){
        if(targetSum < 0){
            if(sum >= targetSum)
                return true;
        }
        else if(sum <= targetSum)
            return true;
        return false;
    }
}
