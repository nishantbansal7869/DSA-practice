package com.practice.hackerRank.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImplementStack {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        Stack stack = new Stack();
        while (test > 0){
            String[] arr = br.readLine().split(" ");
            stackOperation(arr, stack);
            test--;
        }
    }

    private static void stackOperation(String[] arr, Stack stack) {
        String s = arr[0];
        if (s.equals("push")){
            int num = Integer.parseInt(arr[1]);
            stack.push(num);
        }
        else
            System.out.println(stack.pop());
    }
}

class Stack{
    int[] stack;
    int top;
    Stack(){
        stack = new int[10000];
        top = -1;
    }
    void push(int n){
        top++;
        stack[top] = n;
    }
    String pop(){
        if (top == -1)
            return "Empty";
        int n = stack[top];
        --top;
        return Integer.toString(n);
    }
}
