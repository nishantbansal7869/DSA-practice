package com.practice.random;

import java.util.Scanner;

public class StringPallindromeRecursion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        boolean ans = pallindorme(s, 0, s.length()-1);
        System.out.print(ans);
    }

    private static boolean pallindorme(String s, int st, int e) {
        if (st == e)
            return true;
        if (s.charAt(st) != s.charAt(e))
            return false;
        if (st < e+1)
         pallindorme(s, st+1, e-1);
        return true;
    }
}
