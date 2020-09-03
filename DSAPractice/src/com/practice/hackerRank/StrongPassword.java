package com.practice.hackerRank;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StrongPassword {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        int ans = strongPassword(n, s);
        System.out.println(ans);
    }

    private static int strongPassword(int n, String s) {
        String numbers = "0123456789";
        String smallChar = "abcdefghijklmnopqrstuvwxyz";
        String capsChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String specialChar = "!@#$%^&*()-+";

        boolean numberPresent = false;
        boolean smallCharPresent = false;
        boolean capsPresent = false;
        boolean specialCharPresent = false;

        Set<Character> set = new HashSet<>();

        for (int i = 0; i < n; i++)
            set.add(s.charAt(i));

        for (int i = 0; i < numbers.length(); i++){
            if (set.contains(numbers.charAt(i))){
                numberPresent = true;
                break;
            }
        }
        for (int i = 0; i < smallChar.length(); i++){
            if (set.contains(smallChar.charAt(i))){
                smallCharPresent = true;
                break;
            }
        }
        for (int i = 0; i < capsChar.length(); i++){
            if (set.contains(capsChar.charAt(i))){
                capsPresent = true;
                break;
            }
        }
        for (int i = 0; i < specialChar.length(); i++){
            if (set.contains(specialChar.charAt(i))){
                specialCharPresent = true;
                break;
            }
        }
        int count = 0;
        if (!numberPresent)
            count++;
        if (!smallCharPresent)
            count++;
        if (!capsPresent)
            count++;
        if (!specialCharPresent)
            count++;

        if (n < 6 && count < 6 - n)
            return 6 - n;
        if (n < 6 && count > 6 - n)
            return count;

        return count;
    }
}
