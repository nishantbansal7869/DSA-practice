package com.practice.hackerRank.trees;

import java.io.*;

public class NodesAtDistanceK {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String[] arr1 = br.readLine().split(" ");
            int n = Integer.parseInt(arr1[0]);
            int s = Integer.parseInt(arr1[1]);
            int k = Integer.parseInt(arr1[2]);
            int[] arr = new int[n];
            String[] num = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(num[i]);
            treeTraversal(arr, s, k);
            bw.write(ans+"");
            bw.newLine();
            test--;
            ans = 0;
        }
        bw.flush();
    }
    static int ans = 0;
    private static void treeTraversal(int[] arr, int s, int k) {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        find(root, s, k);
    }

    private static int find(Node root, int s, int k){
        if (root == null)
            return 0;
        if (root.data == s)
            return 1;
        int l = find(root.left, s, k);
        if (l != -1){
            ans += count(root.right, k-l-1);
            return l+1;
        }
        int r = find(root.right, s, k);
        if (r != -1){
            ans += count(root.left, k-r-1);
            return r+1;
        }
        return -1;
    }

    private static int count(Node root, int k) {
        if (root == null || k < 0)
            return 0;
        if (k == 0)
            return 1;
        return count(root.left, k-1) + count(root.right, k-1);
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
