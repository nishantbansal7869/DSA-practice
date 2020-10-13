//dummy
package com.practice.interviewbit.tree;

import java.util.ArrayList;

public class KthSmallestElement {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int k = 2;
        int ans = kthSmallestElement(root, k);
        System.out.println(ans);
    }

    private static int kthSmallestElement(TreeNode root, int k) {
        inorderTraverse(root);
        return list.get(k-1);
    }

    static ArrayList<Integer> list = new ArrayList<>();
    private static void inorderTraverse(TreeNode root) {
        if (root == null)
            return;
        inorderTraverse(root.left);
        list.add(root.val);
        inorderTraverse(root.right);
    }
}
