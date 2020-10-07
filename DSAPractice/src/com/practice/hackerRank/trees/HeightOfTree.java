package com.practice.hackerRank.trees;

import java.io.*;

public class HeightOfTree {
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
            int height = heightOfTree(arr);
            bw.write(height + "");
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static int heightOfTree(int[] arr) {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        return height(root);

    }

    private static int height(Node root) {
        if (root == null)
            return -1;
        return 1 + Math.max(height(root.left), height(root.right));
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
