package com.practice.hackerRank;

import java.util.HashSet;
import java.util.Scanner;

public class StrongPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ans = strongPassword(n, s);
        System.out.println(ans);
    }

    private static int strongPassword(int n, String s) {
        String num = "0123456789";
        String lowerCase = "abcdefghijklmnopqrstuvwxyz";
        String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChar = "!@#$%^&*()-+";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++)
            set.add(s.charAt(i));
        boolean containNum = false;
        boolean containLowerCase = false;
        boolean containUpperCase = false;
        boolean containSpecialChar = false;
        for (int i = 0; i < num.length(); i++)
            if (set.contains(num.charAt(i)))
            {
                containNum = true;
                break;
            }
        for (int i = 0; i < lowerCase.length(); i++)
            if (set.contains(lowerCase.charAt(i))){
                containLowerCase = true;
                break;
            }
        for (int i = 0; i < upperCase.length(); i++)
            if (set.contains(upperCase.charAt(i))){
                containUpperCase = true;
                break;
            }
        for (int i = 0; i < specialChar.length(); i++)
            if (set.contains(specialChar.charAt(i))){
                containSpecialChar = true;
                break;
            }
        int count = 0;
        if (!containLowerCase)
            count++;
        if (!containNum)
            count++;
        if (!containUpperCase)
            count++;
        if (!containSpecialChar)
            count++;

        if (s.length() >= 6)
            return count;
        else {
            if (containLowerCase && containNum && containSpecialChar && containUpperCase)
                return 6 - s.length();

        }
        return 1;
    }
}
