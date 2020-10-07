package com.practice.hackerRank.trees;

import java.io.*;

public class TreeTraversals {
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
            treeTraversal(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void treeTraversal(int[] arr)throws IOException {
       Node root = null;
        for (int i : arr)
            root = insert(root, i);
        preOrder(root);
        bw.newLine();
        inorderTraversal(root);
        bw.newLine();
        postOrder(root);
        bw.newLine();
    }

    private static void postOrder(Node root) throws IOException{
        if (root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        bw.write("" + root.data + " ");
    }

    private static void preOrder(Node root)throws IOException {
        if (root == null)
            return;
        bw.write("" + root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void inorderTraversal(Node root)throws IOException {
        if (root == null)
            return;
        inorderTraversal(root.left);
        bw.write("" + root.data + " ");
        inorderTraversal(root.right);
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

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left = null;
        right = null;
    }
}
