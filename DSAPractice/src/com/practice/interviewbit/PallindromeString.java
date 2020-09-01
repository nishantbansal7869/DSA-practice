package com.practice.interviewbit;

import java.util.Scanner;

public class PallindromeString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int check = pallindrome(s);
        System.out.println(check);
    }

    private static int pallindrome(String s) {
         s = s.replaceAll("[^a-zA-Z0-9]", "");
         s = s.toLowerCase();
         if (s.length() == 1)
             return 1;
         int p1 = 0;
         int p2 = s.length()-1;
         while (p1 < p2){
             if (s.charAt(p1) != s.charAt(p2))
                 return 0;
             p1++;
             p2--;
         }
         return 1;
    }
}
