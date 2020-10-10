package com.practice.hackerRank.trees;

import java.io.*;

public class IsBST {
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
           isBST(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void isBST(int[] arr)throws IOException {
        Node root = null;
        root = insert(root, arr, 0);
        boolean ans = isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        bw.write(ans + " ");
    }

    private static boolean isBST(Node root, int a, int b) {
        if (root == null)
            return true;
        return root.data > a && root.data < b &&
                isBST(root.left, a, root.data) &&
                isBST(root.right, root.data, b);
    }

    private static Node insert(Node root, int[] arr, int k) {
        if (k < arr.length){
            Node temp = new Node(arr[k]);
            root = temp;
            root.left = insert(root.left, arr, 2*k+1);
            root.right = insert(root.right, arr, 2*k+2);
        }
        return root;
    }
}
