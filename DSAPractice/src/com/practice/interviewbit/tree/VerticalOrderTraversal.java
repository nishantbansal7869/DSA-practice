package com.practice.interviewbit.tree;

import java.util.*;

public class VerticalOrderTraversal {
    public static void main(String[] args) {
        TreeNode tree = new TreeNode(6);
        tree.left = new TreeNode(3);
        tree.left.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(7);
        tree.right.right = new TreeNode(9);
        ArrayList<ArrayList<Integer>> list = verticalOrderTraversal(tree);
        for (ArrayList<Integer> l : list)
            System.out.println(l);
    }

    private static ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode tree) {
        Map<Integer, ArrayList<Pair>> map = new HashMap<>();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        verticalOrder(tree, map, 0, 0);
        while (true){
            if (map.containsKey(minV)){
                Compare.compare(map.get(minV));
                ArrayList<Integer> l = new ArrayList<>();
                ArrayList<Pair> pl = map.get(minV);
                for (Pair p : pl)
                    l.add(p.data);
                list.add(l);
            }
            else break;
            minV++;
        }
        return list;
    }

    static int minV = Integer.MAX_VALUE;

    private static void verticalOrder(TreeNode tree, Map<Integer, ArrayList<Pair>> map, int v, int d) {
        if (tree == null)
            return;
        if (!map.containsKey(v))
            map.put(v, new ArrayList<>());
        ArrayList<Pair> list = map.get(v);
        list.add(new Pair(tree.val, d));
        map.put(v, list);
        minV = Math.min(minV, v);
        verticalOrder(tree.left, map, v-1, d+1);
        verticalOrder(tree.right, map, v+1, d+1);
    }


}

class Pair{
    int data;
    int depth;
    Pair(int data, int depth) {
        this.data = data;
        this.depth = depth;
    }
}

class Compare{
    static void compare(ArrayList<Pair> list){
        Collections.sort(list, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.depth-o2.depth;
            }
        });
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