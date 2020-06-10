package com.practice.backtrackingQuestion;

import java.util.ArrayList;
import java.util.List;

public class PallindromePartitioning {
    public static void main(String[] args) {
        String s = "aaabaaa";
        List<String> subset = new ArrayList<>();
        List<List<String>> res = new ArrayList<>();
        pallindromePartitioning(s, subset, res, 0);
        res.stream().forEach(str->System.out.println(str));
    }
    public static void pallindromePartitioning(String str, List<String> subset, List<List<String>> res, int index){
        if(index == str.length()) {
            res.add(new ArrayList<>(subset));
            return;
        }
        for(int i = index; i < str.length(); i++){
            subset.add(str.substring(index,i+1));
            if(isSafe(subset.get(subset.size()-1))) {
                pallindromePartitioning(str, subset, res, i + 1);
            }
            subset.remove(subset.size()-1);
        }
        return;
    }
    public static boolean isSafe(String str){
       int i = 0;
       int j = str.length()-1;

       while(i<=j){
          if(str.charAt(i) != str.charAt(j))
              return false;
          i++;
          j--;
       }
       return true;

    }
}
