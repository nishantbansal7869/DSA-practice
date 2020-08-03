package com.practice.hackerRank;

import java.util.HashMap;
import java.util.Scanner;

public class CompressAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String compressed = compressString(s);
        System.out.println(compressed);
    }

    private static String compressString(String s) {
        String s1 = "";
        int count = 1;
        int i = 0;
        while (i < s.length()){
            if (i < s.length()-1 && s.charAt(i+1) == s.charAt(i)){
                count += 1;
            }
            else {
                s1 = s1 + s.charAt(i) + count;
                count = 1;
            }
            i += 1;
        }
        return s1;
    }
}
