package com.practice.hackerRank;

import java.util.Scanner;

public class CountVowelsAndConsonants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int[] count = countVowelAndConsonant(s);
        System.out.println(count[0] + " " + count[1]);
    }

    private static int[] countVowelAndConsonant(String s) {
        s = s.toLowerCase();
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i'
                    || s.charAt(i) == 'o' || s.charAt(i) == 'u')
                count[0]++;
            else
                count[1]++;
        }
        return count;
    }
}

