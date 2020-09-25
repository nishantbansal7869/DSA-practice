package com.practice.hackerRank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimpleTextEditor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int q = Integer.parseInt(br.readLine());
        while (q > 0){
            String s = br.readLine();
            textEditor(s);
            q--;
        }
    }

    static Stack<String> stack = new Stack<>();
    static StringBuilder str = new StringBuilder();

    private static void textEditor(String s) {
        String[] arr = s.split(" ");
        switch (arr[0]) {
            case "1":
                insert(arr[1]);
                break;
            case "2":
                delete(Integer.parseInt(arr[1]));
                break;
            case "3":
                print(Integer.parseInt(arr[1]));
                break;
            default:
                undo();
                break;
        }
    }

    static void insert(String s){
        str.append(s);
        stack.push(str.toString());
    }

    static void delete(int k){
         str.delete(str.length() - k, str.length());
        stack.push(str.toString());
    }

    static void print(int k){
        System.out.println(str.charAt(k-1));
    }

    static void undo(){
        if (!stack.isEmpty()){
            stack.pop();
            if (!stack.isEmpty())
            str = new StringBuilder(stack.peek());
            else
                str = new StringBuilder("");
        }
    }
}
