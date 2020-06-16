package com.practice.backtrackingQuestion;

import java.util.ArrayList;

public class SubsetWithNoDuplicates {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,3};
        ArrayList<Integer> subset = new ArrayList<>();
        subsets(arr,subset,0);
        res.stream().forEach(s->System.out.println(s));
    }
    public  static ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    public static void subsets(int arr[], ArrayList<Integer> subset, int index){
      //  if(!res.contains(subset)){
            res.add(new ArrayList<>(subset));
        //}
        for(int i = index; i < arr.length; i++){
            if(i > index && arr[i] == arr[i-1]){
                continue;
            }
            subset.add(arr[i]);
            subsets(arr,subset,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
