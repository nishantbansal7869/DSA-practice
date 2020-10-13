package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class PreOrderTraversalIterative {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        ArrayList<Integer> list = printPreorder(root);
        System.out.println(list);
    }

    private static ArrayList<Integer> printPreorder(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        PreOrder obj = new PreOrder(root);
        while (obj.hasNext())
            list.add(obj.getNext().val);
        return list;
    }
}

class PreOrder{
    Stack<TreeNode> stack;

    PreOrder(TreeNode root){
        stack = new Stack<>();
        if (root != null)
            stack.push(root);
    }

    boolean hasNext(){
        return !stack.isEmpty();
    }

    TreeNode getNext(){
        TreeNode temp = stack.pop();
        if (temp.right != null)
            stack.push(temp.right);
        if (temp.left != null)
            stack.push(temp.left);
        return temp;
    }
}