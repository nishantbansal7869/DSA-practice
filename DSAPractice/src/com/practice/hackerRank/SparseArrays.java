package com.practice.hackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class SparseArrays {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] strings = new String[n];
        for (int i = 0; i < n; i++)
            strings[i] = sc.next();
        int q = sc.nextInt();
        String[] queries = new String[q];
        for (int i = 0; i < q; i++)
            queries[i] = sc.next();
        int[] ans = solveQuery(strings, queries);
        for (int i : ans)
            System.out.println(i);
    }

    private static int[] solveQuery(String[] strings, String[] queries) {
        HashMap<String, Integer> stringMap = new HashMap<>();
        for (String s : strings){
            if (stringMap.containsKey(s)){
                stringMap.put(s, stringMap.get(s)+1);
            }
            else
                stringMap.put(s, 1);
        }
        int[] ans = new int[queries.length];
        int idx = 0;
        for (String s : queries){
            ans[idx] = stringMap.getOrDefault(s, 0);
            idx++;
        }
        return ans;
    }
}
