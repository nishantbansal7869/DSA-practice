package com.practice.codeforces;

import java.util.Scanner;

public class Word {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String result = change(s);
        System.out.print(result);
    }

    private static String change(String s) {
        int countUpperCase = 0;
        int countLowerCase = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) >= 97 && s.charAt(i) <= 122)
                countLowerCase++;
            else
                countUpperCase++;
        }
        if (countLowerCase >= countUpperCase)
            return s.toLowerCase();
        else
            return s.toUpperCase();
    }
}
