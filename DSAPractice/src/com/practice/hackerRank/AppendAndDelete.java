package com.practice.hackerRank;

import java.util.Scanner;

public class AppendAndDelete {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String t = sc.next();
        int k = sc.nextInt();
        String res = appendAndDelete(s, t, k);
        System.out.println(res);
    }

    private static String appendAndDelete(String s, String t, int k) {
        if (s.equals(t))
            return "Yes";
        int p1 = 0;
        int p2 = 0;
        while (p1 < s.length() && p2 < t.length()){
            if (s.charAt(p1) != t.charAt(p2)){
                break;
            }
            p1++;
            p2++;
        }
        int count = Math.abs(p1 - s.length());
        int temp = k - count;
        if (temp < 0)
            return "No";
        count =t.length() - p2;
        if (temp <= count)
            return "Yes";
        return "No";
    }
}
