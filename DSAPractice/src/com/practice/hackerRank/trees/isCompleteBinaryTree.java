package com.practice.hackerRank.trees;

import java.io.*;

public class isCompleteBinaryTree {
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
            completeBinaryTree(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void completeBinaryTree(int[] arr) throws IOException{
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        boolean ans = isCompletetree(root);
        bw.write(ans+"");
    }

    private static boolean isCompletetree(Node root) {
        if (root == null)
            return true;
        if ((root.left == null && root.right != null) || (root.left != null && root.right == null
                && (root.left.left != null || root.left.right != null)))
            return false;
        if (!isCompletetree(root.left))
            return false;
        return isCompletetree(root.right);
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
