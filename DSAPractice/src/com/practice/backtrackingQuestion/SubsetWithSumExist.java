package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SubsetWithSumExist {
    public static void main(String[] args) {
        int arr[] = new int[]{10,15,25};

        int sum = 35;
        System.out.println(subsetExist(arr,arr.length,0,sum));
    }
    public static boolean subsetExist(int arr[], int n, int index, int sum){
        ArrayList<Integer> subset = new ArrayList<>() ;
        return subsetExistO(arr,n,index,subset,sum,sum);
    }
    public static boolean subsetExistO(int arr[], int n, int index,ArrayList<Integer> subset, int targetsum, int sum){
        if(sum == 0){
            return true;
        }
        for(int i = index; i < n; i++){
            if(isSafe(subset,arr[i], targetsum)){
                subset.add(arr[i]);
                if(subsetExistO(arr,n,index+1,subset,targetsum,sum-subset.get(subset.size()-1))){
                    return true;
                }
                subset.remove(subset.size()-1);
            }
        }
        return false;
    }
    public static boolean isSafe(ArrayList<Integer> subset, int n, int targetSum){
        int sum = Integer.parseInt(subset.stream().collect(Collectors.summingInt(Integer::intValue)).toString());
        sum += n;
        return sum <= targetSum;
    }
}
