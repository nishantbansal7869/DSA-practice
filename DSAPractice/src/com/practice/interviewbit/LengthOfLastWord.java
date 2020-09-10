package com.practice.interviewbit;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LengthOfLastWord {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int ans = findLength(s);
        System.out.println(ans);
    }

    private static int findLength(String s) {
        int count = 0;
        int ans = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) != ' ') {
                count++;
                ans = count;
            }
            if (s.charAt(i) == ' '){
                count = 0;
            }
        }
        return ans;
    }
}
