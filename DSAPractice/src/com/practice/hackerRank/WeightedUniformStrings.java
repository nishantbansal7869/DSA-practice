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
        for (int i = 0; i < s.length(); i++)
           count[s.charAt(i)-'a']++;
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
