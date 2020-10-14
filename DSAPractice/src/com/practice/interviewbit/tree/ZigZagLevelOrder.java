package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class ZigZagLevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        ArrayList<ArrayList<Integer>> ans = zigZagTraversal(root);
        for (ArrayList<Integer> list : ans)
            System.out.println(list);
    }

    private static ArrayList<ArrayList<Integer>> zigZagTraversal(TreeNode root) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        Stack<TreeNode> cur = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        boolean leftToRight = true;
        cur.push(root);
        ArrayList<Integer> tempList = new ArrayList<>();
        while (!cur.isEmpty()){
            TreeNode temp = cur.pop();
            tempList.add(temp.val);
            if (leftToRight){
                if (temp.left != null)
                    next.push(temp.left);
                if (temp.right != null)
                    next.push(temp.right);
            }
            else {
                if (temp.right != null)
                    next.push(temp.right);
                if (temp.left != null)
                    next.push(temp.left);
            }
            if (cur.isEmpty()){
                list.add(new ArrayList<>(tempList));
                tempList.clear();
                Stack<TreeNode> tempStack = cur;
                cur = next;
                next = tempStack;
                leftToRight = !leftToRight;
            }
        }
        return list;
    }
}
