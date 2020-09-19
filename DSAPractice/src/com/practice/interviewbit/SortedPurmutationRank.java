package com.practice.interviewbit;

import java.util.Scanner;

public class SortedPurmutationRank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = getRank(s);
        System.out.println(ans);
    }

    private static int getRank(String s) {
        int m = 1000003;
        int ans = 0;
        while (s.length() != 1){
            int factorial = calculateFactorial(s.length()-1, m);
            int charLessThanFirstChar = getCharLessThanFirstChar(s);
            ans += (int)(((long)(factorial*charLessThanFirstChar))%m);
            s = s.substring(1);
        }
        return (ans + 1)%m;
    }

    private static int getCharLessThanFirstChar(String s) {
        int count = 0;
        char c = s.charAt(0);
        int i = 1;
        while (i < s.length()){
            if (s.charAt(i) < c)
                count++;
            i++;
        }
        return count;
    }

    private static int calculateFactorial(int i, int m) {
        int factorial = 1;
        while (i >= 1){
            factorial = (int)((long)(factorial * i)%m);
            i--;
        }
        return factorial;
    }
}
