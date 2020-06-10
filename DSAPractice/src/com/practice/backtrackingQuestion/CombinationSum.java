/*
 *Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]
 */
package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {
    public static void main(String[] args) {
        int arr[]= new int[]{2,3,5};
        Arrays.sort(arr);
        ArrayList<Integer> subset = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int targetSum = 8;
        subsets(arr,subset,res,targetSum,targetSum,0);
        res.stream().forEach(s -> System.out.println(s));
    }
    public static void subsets(int arr[], ArrayList<Integer> subset,  ArrayList<ArrayList<Integer>> res, int targetSum
    ,int sum, int index)
    {
        if(sum<0)
            return;
        if(sum == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i = index; i < arr.length; i++){
            subset.add(arr[i]);
            subsets(arr,subset,res,targetSum,sum-subset.get(subset.size()-1),i);
            subset.remove(subset.size()-1);
        }
        return;
    }
}
