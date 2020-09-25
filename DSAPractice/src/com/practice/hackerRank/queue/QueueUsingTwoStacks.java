package com.practice.hackerRank.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class QueueUsingTwoStacks{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        while (n > 0)
        {
            String s = br.readLine();
            queueImplement(s);
            n--;
        }
    }

    static Stack<Integer> stack = new Stack<>();
    static Stack<Integer> stack1 = new Stack<>();

    private static void queueImplement(String s) {
        String[] arr = s.split(" ");
        switch (arr[0]){
            case "1": enqueue(Integer.parseInt(arr[1]));
            break;
            case "2": dequeue();
            break;
            case "3": printElement();
            break;
        }
    }

    private static void printElement() {
        if (stack1.isEmpty() && !stack.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.peek());
                stack.pop();
            }
        }
        System.out.println(stack1.peek());
    }

    private static void dequeue() {
        if (stack1.isEmpty() && !stack.isEmpty()){
            while (!stack.isEmpty()){
                stack1.push(stack.peek());
                stack.pop();
            }
        }
        stack1.pop();
    }

    private static void enqueue(int n) {
        stack.push(n);
    }
}
