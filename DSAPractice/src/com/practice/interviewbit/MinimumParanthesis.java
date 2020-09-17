package com.practice.interviewbit;

import java.util.Scanner;

public class MinimumParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = minimumParanthesis(s);
        System.out.println(ans);
    }

    private static int minimumParanthesis(String s) {
        int balance = 0;
        int close = 0;
        for(char c : s.toCharArray()){
            balance += c == '(' ? 1 : -1;
            if(balance == -1){
                close++;
                balance++;
            }
        }
        return Math.abs(balance+close);
    }
}
