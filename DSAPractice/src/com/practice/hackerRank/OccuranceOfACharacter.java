package com.practice.hackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class OccuranceOfACharacter {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String s1 = br.readLine();
        char ch = s1.charAt(0);
        int occurance = countChar(s, ch);
        System.out.println(occurance);
    }

    private static int countChar(String s, char ch) {
        s = s.toLowerCase();
        int count = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ch)
                count++;
        }
        return count;
    }
}
