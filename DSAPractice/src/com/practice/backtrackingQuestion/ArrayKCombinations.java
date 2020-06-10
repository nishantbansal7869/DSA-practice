/*
* Given two integers n and k, return all possible combinations of k numbers out of 1 2 3 ... n.

Make sure the combinations are sorted.

To elaborate,

Within every entry, elements should be sorted. [1, 4] is a valid entry while [4, 1] is not.
Entries should be sorted within themselves.
Example :
If n = 4 and k = 2, a solution is:

[
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
]
* */
package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.List;

public class ArrayKCombinations {
    public static void main(String[] args) {
        int n = 6;
        int k = 3;
        List<Integer> subset = new ArrayList<>();
        List<ArrayList<Integer>> res = new ArrayList<>();
        findCombination(n,k,subset,res,1);
        int arr1[][] = new int[res.size()][k];
        for(int i = 0; i < res.size(); i++){
            List<Integer> s = res.get(i);
            for(int j = 0; j < k;j++)
                arr1[i][j] = s.get(j);
        }
        for(int i = 0; i < res.size(); i++){
            for(int j = 0; j < k;j++)
                System.out.print(arr1[i][j]);
            System.out.println();
        }
        //res.stream().forEach(s -> System.out.println(s));
    }
    public static void findCombination(int n, int k, List<Integer> subset, List<ArrayList<Integer>> res, int index){
        if(k == 0){
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i = index; i <= n; i++){
            subset.add(i);
            findCombination(n,k-1,subset,res,i+1);
            subset.remove(subset.size()-1);
        }
    }
}
