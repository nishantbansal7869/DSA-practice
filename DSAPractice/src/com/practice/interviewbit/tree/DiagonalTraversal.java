package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DiagonalTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(9);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.left = new TreeNode(6);
        ArrayList<Integer> list = solve(root);
        System.out.println(list);
    }

    private static ArrayList<Integer> solve(TreeNode root) {
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        diagonalTraversal(root, map, 0, 0);
        int v = 0;
        while (true){
            if (map.containsKey(v)){
                ArrayList<Pair> pl = map.get(v);
                for (Pair p : pl)
                    list.add(p.data);
            }
            else
                break;
            v++;
        }
        return list;
    }

    private static void diagonalTraversal(TreeNode root, Map<Integer, ArrayList<Pair>> map, int v, int d) {

        if (root == null)
            return;

        if (!map.containsKey(v))
            map.put(v, new ArrayList<>());
        ArrayList<Pair> list = map.get(v);
        list.add(new Pair(root.val, d));
        map.put(v, list);

        diagonalTraversal(root.left, map, v+1, d+1);
        diagonalTraversal(root.right, map, v, d+1);
    }
}
