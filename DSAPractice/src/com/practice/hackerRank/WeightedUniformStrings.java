package com.practice.hackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class WeightedUniformStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String  s = sc.next();
        int n = sc.nextInt();
        int[] queries = new int[n];
        for (int i = 0; i < n; i++)
            queries[i] = sc.nextInt();
        String[] ans = weightedUniformStrings(s, queries);
        for (String str : ans)
            System.out.println(str);
    }

    private static String[] weightedUniformStrings(String s, int[] queries) {
        String ans[]  = new String[queries.length];
        int[] count = new int[26];
        int l = 0;
        while (l < s.length()){
            char c = s.charAt(l);
            int j = l;
            if (count[c - 'a'] == 0) {
                while (j < s.length() && s.charAt(j) == c) {
                    count[c - 'a']++;
                    j++;
                }
            }
            l++;
        }
        int idx = 0;
        boolean flag = false;
        for (int q : queries){
            for (int i = 0; i < 26; i++){
                if (q % (i+1) == 0 && q/(i+1) <= count[i])
                {
                    flag = true;
                    ans[idx++] = "Yes";
                    break;
                }
            }
            if (!flag)
                ans[idx++] = "No";
            flag = false;
        }
        return ans;
    }
}
