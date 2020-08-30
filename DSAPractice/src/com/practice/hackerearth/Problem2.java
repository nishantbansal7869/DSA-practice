/*
* You are given two string S and T. Find the maximal length of some prefix of the string S which occurs in strings T
*  as subsequence.

Input
The first line contains string S. The second line contains string T. Both strings consist of lowecase Latin letters.

Output
Output one integer - answer to the question.

Constraints
1 <= length of S, T <= 106

SAMPLE INPUT
digger
biggerdiagram
SAMPLE OUTPUT
3
* */
package com.practice.hackerearth;

import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int ans = find(s, t);
        System.out.println(ans);
    }

    private static int find(String s, String t) {
        if (s.equals(t))
            return s.length();
        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()){
            if (s.charAt(i) != t.charAt(j))
                j++;
            else {
                i++;
                j++;
            }
        }
        return i;
    }
}
