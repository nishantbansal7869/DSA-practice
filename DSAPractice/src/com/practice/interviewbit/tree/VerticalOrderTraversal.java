package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        ArrayList<ArrayList<Integer>> ans = verticalOrder(tree);
        for (ArrayList<Integer> l : ans)
            System.out.println(l);
    }

    static int minV = 0;
    private static ArrayList<ArrayList<Integer>> verticalOrder(TreeNode tree) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        verticalOrder(tree, 0, map);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        while (true){
            if (map.containsKey(minV))
                list.add(map.get(minV));
            else
                break;
            minV++;
        }
        return list;
    }

    private static void verticalOrder(TreeNode tree, int v, Map<Integer, ArrayList<Integer>> map) {
        if (tree == null)
            return;
        if (!map.containsKey(v))
            map.put(v,new ArrayList<>());
        ArrayList<Integer> list = map.get(v);
        list.add(tree.val);
        minV = Math.min(minV, v);
        map.put(v,list);
        verticalOrder(tree.left, v-1, map);
        verticalOrder(tree.right, v+1, map);
    }
}

class TreeNode {
     int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) {
       val = x;
       left=null;
       right=null;
      }
}