package com.practice.interviewbit.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = balancedOrNot(s);
        System.out.println(ans);
    }

    private static int balancedOrNot(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == '(')
                stack.push('(');
            if (s.charAt(i) == ')')
            {
                if (stack.isEmpty())
                    return 0;
                else
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
