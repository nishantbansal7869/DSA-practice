package com.practice.interviewbit.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimplifyDirectoryPath {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String ans = directoryPath(s);
        System.out.println(ans);
    }

    private static String directoryPath(String s) {
        String[] arr = s.split("/");
        Stack<String> stack = new Stack<>();
        if (s.equals("/"))
            return "/";
        for (String str : arr){
            if (str.equals(".") || str.equals(""))
                continue;
            else if (str.equals("..") && !stack.isEmpty())
                stack.pop();
            else
                stack.push(str);
        }
        StringBuilder sb = new StringBuilder("/");
        for (String str : stack)
            sb.append(str).append("/");
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}
