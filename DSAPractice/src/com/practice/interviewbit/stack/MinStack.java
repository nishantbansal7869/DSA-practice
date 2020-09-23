package com.practice.interviewbit.stack;

import java.util.Stack;

public class MinStack {
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
class Solution {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    public Solution(){
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty())
            minStack.push(x);
        else if (x < minStack.peek())
            minStack.push(x);
        else
            minStack.push(minStack.peek());
    }

    public void pop() {
        if(!stack.isEmpty()){
            stack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(stack.isEmpty())
            return -1;
        return stack.peek();
    }

    public int getMin() {
        if(minStack.isEmpty())
            return -1;
        return minStack.peek();
    }
}