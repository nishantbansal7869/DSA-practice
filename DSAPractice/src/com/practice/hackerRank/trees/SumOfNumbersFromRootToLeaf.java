package com.practice.hackerRank.trees;

import java.io.*;

public class SumOfNumbersFromRootToLeaf {
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
           sum(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }

    private static void sum(int[] arr)throws IOException {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        long sum = findSum(root, 0);
        bw.write(sum+ "");
    }

    static int m = (int)1e9+7;

    private static long findSum(Node root, long val) {
        if (root == null)
            return 0;
        val = ((val * getPower( digits(root.data)) % m) + root.data)%m;
        if (root.left == null && root.right == null)
            return val;
        return findSum(root.left, val) + findSum(root.right, val);
    }

    private static long digits(int data) {
        if (data == 0)
            return 1;
        long c = 0;
        while (data != 0){
            data = data/10;
            c++;
        }
        return c;
    }

    private static long getPower(long l) {
        if (l == 0)
            return 1;
        long x = getPower(l/2);
        if (l%2 == 0)
            return (x*x)%m;
        else
            return (10*(x*x)%m)%m;
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
