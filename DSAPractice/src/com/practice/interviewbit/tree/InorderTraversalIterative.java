package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Stack;

public class InorderTraversalIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ArrayList<Integer> list = inorderTraversal(root);
        System.out.println(list);
    }

    private static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (true){
            TreeNode temp = root;
            while (temp!= null){
                stack.push(temp);
                temp = temp.left;
            }
            if (stack.isEmpty())
                break;
            temp = stack.pop();
            list.add(temp.val);
            root = temp.right;
        }
        return list;
    }
}
