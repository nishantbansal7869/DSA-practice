package com.practice.recurssionQuestions;

import java.util.ArrayList;
import java.util.List;

public class SubsetOfArrayPrint {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,2};
        List<Integer> subset = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        subsetArray(arr,subset,res,0);
        for(int i = 0; i < res.size(); i++){
            System.out.println(res.get(i));
        }
    }
    public static void subsetArray(int arr[], List<Integer> subset, List<List<Integer>> res, int index){
        res.add(new ArrayList<>(subset));
        for(int i = index; i < arr.length; i++){
            subset.add(arr[i]);
            subsetArray(arr, subset, res, i + 1);
            subset.remove(subset.size() - 1);
        }
        return;
    }
}
