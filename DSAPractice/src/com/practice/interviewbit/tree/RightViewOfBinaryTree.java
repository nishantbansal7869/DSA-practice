package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class RightViewOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(3);
        ArrayList<Integer> ans = rightView(root);
        System.out.println(ans);
    }

    private static ArrayList<Integer> rightView(TreeNode root) {
        Stack<TreeNode> cur = new Stack<>();
        Stack<TreeNode> next = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> rightView = new ArrayList<>();
        cur.add(root);
        while (!cur.isEmpty()){
            TreeNode temp = cur.pop();
            list.add(temp.val);
            if (temp.right != null)
                next.add(temp.right);
            if (temp.left != null)
                next.add(temp.left);
            if (cur.isEmpty()){
                rightView.add(list.get(list.size()-1));
                list.clear();
                Stack<TreeNode> tempStack = cur;
                cur = next;
                next = tempStack;
            }
        }
        return rightView;
    }
}
