package com.practice.hackerRank.trees;

import java.io.*;

public class IsFullBinaryTree {
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
            fullBinaryTree(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void fullBinaryTree(int[] arr)throws IOException {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        boolean ans = isFullBinaryTree(root);
        if (ans)
            bw.write("True");
        else
            bw.write("False");
    }

    private static boolean isFullBinaryTree(Node root) {
        if (root == null)
            return true;
        if (root.left != null && root.right == null || root.right != null && root.left == null)
            return false;
        if (!isFullBinaryTree(root.left))
            return false;
        return isFullBinaryTree(root.right);
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
