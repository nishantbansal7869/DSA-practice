package com.practice.hackerRank.stack;

import java.io.*;
import java.util.Stack;

public class CollectingMangoes {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 1; i <= test; i++){
            Stack<Integer> stack1 = new Stack<>();
            Stack<Integer> stack2 = new Stack<>();
            int n = Integer.parseInt(br.readLine());
            bw.write("Case " + i + ":");
            bw.newLine();
            while (n > 0) {
                String s = br.readLine();
                performOperations(s, stack1, stack2);
                n--;
            }
        }
        bw.flush();
    }

    private static void performOperations(String s, Stack<Integer> stack1, Stack<Integer> stack2) throws IOException{
        String[] arr = s.split(" ");
        if (arr[0].equals("A")){
            int n = Integer.parseInt(arr[1]);
            stack1.push(n);
            if (stack2.empty())
                stack2.push(n);
            else
                if (n > stack2.peek())
                    stack2.push(n);
                else
                    stack2.push(stack2.peek());
        }
        else if (arr[0].equals("R")){
            if (!stack1.empty()) {
                stack1.pop();
                stack2.pop();
            }
        }
        else {
            if (!stack2.empty()) {
                bw.write(stack2.peek() + " ");
                bw.newLine();
            }
            else {
                bw.write("Empty");
                bw.newLine();
            }
        }
    }
}
