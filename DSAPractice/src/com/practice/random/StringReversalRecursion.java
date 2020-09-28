package com.practice.random;

import java.util.Scanner;

public class StringReversalRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        String ans = reverseString(s, s.length()-1, sb);
        System.out.println(ans);
    }

    private static String reverseString(String s, int idx, StringBuilder sb) {
        if (idx < 0)
            return sb.toString();
        return reverseString(s, idx - 1, sb.append(s.charAt(idx)));
    }
}
