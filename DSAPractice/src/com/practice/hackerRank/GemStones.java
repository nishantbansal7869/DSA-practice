package com.practice.hackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class GemStones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.next();
        int ans = countGems(arr);
        System.out.println(ans);
    }

    private static int countGems(String[] arr) {
        int[] count = new int[26];
        for (String s : arr){
            HashSet<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++){
                set.add(s.charAt(i));
            }
            for (Character c : set)
                count[c-'a']++;
        }
        int countGems = 0;
        for (int i = 0; i < 26; i++){
            if (count[i] == arr.length)
                countGems++;
        }
        return countGems;
    }
}
