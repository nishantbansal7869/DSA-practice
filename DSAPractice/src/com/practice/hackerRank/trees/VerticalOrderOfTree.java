package com.practice.hackerRank.trees;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderOfTree {
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
            verticalOrder(arr);
            bw.newLine();
            test--;
        }
        bw.flush();
    }
    static  int minV = Integer.MAX_VALUE;
    private static void verticalOrder(int[] arr) throws IOException {
        Node root = null;
        for (int i : arr)
            root = insert(root, i);
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        printVerticalOrder(root, 0, map);
        while (true){
            if (map.containsKey(minV)){
                ArrayList<Integer> list = map.get(minV);
                Collections.sort(list);
                for (int i : list)
                    bw.write(i + " ");
                bw.newLine();
            }
            else
                break;
            minV++;
        }
    }

    private static void printVerticalOrder(Node root, int v, Map<Integer, ArrayList<Integer>> map) {
        if (root == null)
            return;
        if (!map.containsKey(v))
            map.put(v, new ArrayList<>());
        ArrayList<Integer> list = map.get(v);
        list.add(root.data);
        map.put(v, list);
        minV = Math.min(minV, v);
        printVerticalOrder(root.left, v-1, map);
        printVerticalOrder(root.right, v+1, map);
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
