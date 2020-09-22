package com.practice.hackerRank.stack;

import java.io.*;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            int[] stocks = new int[n];
            for (int i = 0; i < n; i++){
                stocks[i] = Integer.parseInt(arr[i]);
            }
            int[] ans = stockSpan(stocks, n);
            for (int i : ans)
                bw.write(i + " ");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int[] stockSpan(int[] stocks, int n) {
        int[] maxRight = findFirstMaxOnRight(stocks, n);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++)
            ans[i] = i - maxRight[i];
        return ans;
    }

    private static int[] findFirstMaxOnRight(int[] stocks, int n) {
        Stack<Integer> stack = new Stack<>();
        int[] maxRight = new int[n];
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && stocks[stack.peek()] <= stocks[i])
                stack.pop();
            maxRight[i] = stack.size() == 0 ? -1 : stack.peek();
            stack.push(i);
        }
        return maxRight;
    }
}
