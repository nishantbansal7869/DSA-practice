/*
* Given a collection of distinct integers, return all possible permutations.

Example:

Input: [1,2,3]
Output:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
* */
package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PermutationOfAnArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        List<List<Integer>> res = new ArrayList<>();
        permutation(arr,0,arr.size()-1,res);
        res.stream().forEach(s->System.out.println(s));
    }
    public static void permutation(ArrayList<Integer> arr, int l, int r, List<List<Integer>> res){
        if(l == r){
            //System.out.println(arr);
            res.add(new ArrayList<>(arr));
            return;
        }
        for(int i = l; i <= r; i++){
            Collections.swap(arr,l,i);
            permutation(arr,l+1,r,res);
            Collections.swap(arr,l,i);
        }
    }
}
