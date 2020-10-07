package com.practice.hackerRank.trees;

import java.io.*;
import java.util.*;

public class ZigZagBottomUp {
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
        Map<Integer, List<Integer>> map = new HashMap<>();
        zigZagOrder(root, map);
        while (maxD >= 0){
            if (map.containsKey(maxD))
                for (int i : map.get(maxD))
                    bw.write(i + " ");
                maxD--;
        }
    }
    static int maxD;
    private static void zigZagOrder(Node root, Map<Integer, List<Integer>> map) {
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();
        boolean leftToRight = false;
        currentLevel.push(root);
        int d = 0;
        while (!currentLevel.isEmpty()){
            Node temp = currentLevel.pop();
            if (!map.containsKey(d))
                map.put(d, new ArrayList<>());
            List<Integer> list = map.get(d);
            list.add(temp.data);
            map.put(d, list);
            maxD = Math.max(maxD, d);
            if (leftToRight){
                if (temp.left != null)
                    nextLevel.add(temp.left);
                if (temp.right != null)
                    nextLevel.add(temp.right);
            }
            else {
                if (temp.right != null)
                    nextLevel.add(temp.right);
                if (temp.left != null)
                    nextLevel.add(temp.left);
            }
            if (currentLevel.isEmpty()){
                leftToRight = !leftToRight;
                d+=1;
                Stack<Node> tempStack = currentLevel;
                currentLevel = nextLevel;
                nextLevel = tempStack;
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
