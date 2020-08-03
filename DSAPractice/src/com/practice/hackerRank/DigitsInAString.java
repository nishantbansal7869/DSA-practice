package com.practice.hackerRank;

import java.util.Scanner;

public class DigitsInAString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String present = check(s);
        System.out.println(present);
    }

    private static String check(String s) {
        for (int i = 0; i < s.length(); i++){
            if (!(s.charAt(i) >= 48 && s.charAt(i) <= 57))
                return "No";
        }
        return "Yes";
    }
}
