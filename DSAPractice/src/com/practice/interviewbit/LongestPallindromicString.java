package com.practice.interviewbit;

import java.util.Scanner;

public class LongestPallindromicString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = longestPallindromicString(s);
        System.out.println(ans);
    }

    private static String longestPallindromicString(String s) {
        if (s.length() == 1)
            return s;
        String oddSubstring = checkOdd(s);
        String evenSubstring = checkEven(s);
        if (oddSubstring.length() > evenSubstring.length())
            return oddSubstring;
        return evenSubstring;
    }

    private static String checkEven(String s) {
        String s1 = s.substring(0, 1);
        int ans = Integer.MIN_VALUE;
        int i = 0;
        while (i < s.length()-1){
            int p1 = i;
            int p2 = i+1;
            while (p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
                p1--;
                p2++;
            }
            if(p2-p1-1 > ans){
                ans = p2-p1-1;
                s1 = s.substring(p1+1, p2);
            }
            i++;
        }
        return s1;
    }
    private static String checkOdd(String s) {
        String s1 = s.substring(0, 1);
        int ans = Integer.MIN_VALUE;
        int i = 1;
        while (i < s.length()-1){
            int p1 = i-1;
            int p2 = i+1;
            while (p1 >= 0 && p2 < s.length() && s.charAt(p1) == s.charAt(p2)){
                p1--;
                p2++;
            }
            if(p2-p1-1 > ans){
                ans = p2-p1-1;
                s1 = s.substring(p1+1, p2);
            }
            i++;
        }
        return s1;
    }
}
