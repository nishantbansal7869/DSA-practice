package com.practice.hackerRank.trees;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BottomUpLevelOrder {
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
    static int maxD;
    private static void levelOrderTraversal(int[] arr) throws IOException{
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        levelOrder(root, 0, map);
        while (maxD >= 0){
            if (map.containsKey(maxD))
                for (int i : map.get(maxD))
                    bw.write(i + " ");
                bw.newLine();
            maxD--;
        }
    }

    private static void levelOrder(Node root, int d, Map<Integer, ArrayList<Integer>> map) {
        if(root == null)
            return;
        if (!map.containsKey(d))
            map.put(d, new ArrayList<>());
        ArrayList<Integer> list = map.get(d);
        list.add(root.data);
        map.put(d, list);
        maxD = Math.max(d, maxD);
        levelOrder(root.left, d+1,map);
        levelOrder(root.right, d+1, map);
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
