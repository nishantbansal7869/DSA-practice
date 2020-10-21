package com.practice.hackerRank.trees;

import java.io.*;

public class LCA {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        while (test > 0){
            String[] sarr = br.readLine().split(" ");
            int n = Integer.parseInt(sarr[0]);
            int q = Integer.parseInt(sarr[1]);
            int[] arr = new int[n];
            String[] num = br.readLine().split(" ");
            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(num[i]);
            Node root = lca(arr);
            while (q > 0)
            {
                String sArr[] = br.readLine().split(" ");
                int n1 = Integer.parseInt(sArr[0]);
                int n2 = Integer.parseInt(sArr[1]);
                Node ans = findLCA(root, n1, n2);
                bw.write(ans.data+" ");
                q--;
            }
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static Node findLCA(Node root, int n1, int n2) {
        if (root == null)
            return root;
        if (root.data > n1 && root.data > n2)
            return findLCA(root.left, n1, n2);
        if (root.data < n1 && root.data < n2)
            return findLCA(root.right, n1, n2);
        return root;
    }

    private static Node lca(int[] arr){
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        return root;
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
