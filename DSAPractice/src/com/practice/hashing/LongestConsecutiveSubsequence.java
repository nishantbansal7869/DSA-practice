package com.practice.hashing;

import java.util.Hashtable;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        int[] arr = {10,90,30,40,20,20};
        int count = longestSubsequence(arr);
        System.out.print(count);
    }

    private static int longestSubsequence(int[] arr) {
        Hashtable<Integer,Integer> table = new Hashtable<>(arr.length);
        for(int i : arr){
            table.put(i,0);
        }
        int curr = 1;
        int res = 1;
        for(int i : arr){
            if(!table.containsKey(i-1)){
                curr = 1;
                while (table.containsKey(i + curr)){
                    curr++;
                }
            }
            res = Math.max(res,curr);
        }
        return res;
    }

}
