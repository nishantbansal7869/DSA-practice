package com.practice.interviewbit.stack;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class NearestSmallerElement {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sArr = br.readLine().split(" ");
        int[] arr = new int[sArr.length];
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(sArr[i]);
        int[] ans  = nearestSmallest(arr);
        for (int i : ans)
            System.out.println(i);
    }

    private static int[] nearestSmallest(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && stack.peek() > arr[i])
                stack.pop();
            ans[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(arr[i]);
        }
        return ans;
    }
}
