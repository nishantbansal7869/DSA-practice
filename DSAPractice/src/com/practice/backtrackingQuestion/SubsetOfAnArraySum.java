package com.practice.backtrackingQuestion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetOfAnArraySum {
    public static void main(String[] args) {
        int arr[] = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(arr);
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        int sum = 8;
        subsetArray1(arr,subset,res,0,sum);
        if(res.size() == 0){
            System.out.println(-1);
        }
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    public static void subsetArray1(int arr[], List<Integer> subset,  List<List<Integer>> res, int index,int sum){
        subsetArray(arr,subset,res,index,sum,sum);
    }
    public static void subsetArray(int arr[], List<Integer> subset, List<List<Integer>> res, int index,int targetSum,int sum){
        if(sum < 0)
            return;
        if(sum == 0) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1])
                continue;
            //if(isSafe(subset,arr[i],targetSum)) {
                subset.add(arr[i]);
                subsetArray(arr, subset, res, i + 1,targetSum,sum-subset.get(subset.size()-1));
                subset.remove(subset.size() - 1);
            //}
        }
        return;
    }
    /*public static boolean isSafe(List<Integer> subset, int a, int targetSum){
        int sum = 0;
        for(int i = 0; i < subset.size();i++){
            sum += subset.get(i);
        }
        sum += a;
        if(sum <= targetSum){
            return true;
        }
        return false;
    }*/
}
