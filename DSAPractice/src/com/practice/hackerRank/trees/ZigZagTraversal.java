package com.practice.hackerRank.trees;

import java.io.*;
import java.util.Stack;

public class ZigZagTraversal {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] num = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(num[i]);
            zigZagTraversal(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void zigZagTraversal(int[] arr)throws IOException {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        zigZagOrder(root);
    }

    private static void zigZagOrder(Node root) throws IOException {
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = false;
        currentLevel.push(root);
        while (!currentLevel.isEmpty()){
            Node temp = currentLevel.pop();
            bw.write(temp.data + " ");
            if (leftToRight){
                if (temp.left != null)
                    nextLevel.push(temp.left);
                if (temp.right != null)
                    nextLevel.push(temp.right);
            }
            else {
                if (temp.right != null)
                    nextLevel.push(temp.right);
                if (temp.left != null)
                    nextLevel.push(temp.left);
            }
            if (currentLevel.isEmpty()){
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
                leftToRight = !leftToRight;
            }
        }
    }

    private static Node insert(Node root, int i) {
        if (root == null)
            return new Node(i);
        if (root.data > i)
            root.left = insert(root.left, i);
        else
            root.right = insert(root.right, i);
        return root;
    }
}
