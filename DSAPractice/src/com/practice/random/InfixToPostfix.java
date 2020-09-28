package com.practice.random;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class InfixToPostfix {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        String postfix = infixToPostfix(s);
        System.out.println(postfix);
    }

    private static String infixToPostfix(String[] s) {
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("*", 1);
        map.put("/", 1);
        map.put("+", 2);
        map.put("-", 2);
        map.put("(", 3);

        for (String token : s){
            if (token.matches("[A-Z]")){
                sb.append(token);
            }
            else if (token.equals("(")){
                stack.push(token);
            }
            else if (token.equals(")")){
                while (!stack.isEmpty() && !stack.peek().equals("(")){
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.pop();
            }
            else {
                while (!stack.isEmpty() && map.get(stack.peek()) <= map.get(token)) {
                    sb.append(stack.peek());
                    stack.pop();
                }
                stack.push(token);
            }
        }
        while (!stack.isEmpty())
        {
            sb.append(stack.peek());
            stack.pop();
        }
        return sb.toString();
    }
}
