package com.practice.hackerRank.trees;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class LevelOrderOfTree {
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
            levelOrderTraversal(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void levelOrderTraversal(int[] arr) throws IOException {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        levelOrderPrint(root);
    }

    private static void levelOrderPrint(Node root) throws IOException{
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()){
            int count = queue.size();
            while (count > 0){
                Node temp = queue.poll();
                bw.write(temp.data + " ");
                if (temp.left != null)
                    queue.add(temp.left);
                if (temp.right != null)
                    queue.add(temp.right);
                count--;
            }
            bw.newLine();
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
