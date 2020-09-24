package com.practice.hackerRank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ChangingDirectories {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            while (n > 0){
                String command = br.readLine();
                changingDirectories(command);
                System.out.println();
                n--;
            }
            test--;
        }
    }
    static Stack<String> stack = new Stack<>();
    private static void changingDirectories(String command) {
        String[] arr = command.split(" ");
        StringBuilder path = new StringBuilder("/");
        if (arr[0].equals("pwd")){
            for (String s : stack){
                path.append(s).append("/");
            }
            System.out.println(path);
        }
        else if (arr[1].equals("/"))
            while (!stack.isEmpty())
                stack.pop();
        else {
            String[] paths = arr[1].split("/");
            for (String s : paths){
                if (s.equals("")){
                    while (!stack.isEmpty())
                        stack.pop();
                }
                else if (s.equals("..") && !stack.isEmpty())
                    stack.pop();
                else
                    stack.push(s);
            }
        }
    }
}
