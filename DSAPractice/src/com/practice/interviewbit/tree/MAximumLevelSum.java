package com.practice.interviewbit.tree;

import java.util.ArrayDeque;
import java.util.Queue;

public class MAximumLevelSum {
    /**
     * Definition for binary tree
     * class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) {
     *      val = x;
     *      left=null;
     *      right=null;
     *     }
     * }
     */
    class Solution {
        public int solve(TreeNode root) {
            int ans = levelOrderPrint(root);
            return ans;
        }

        private int levelOrderPrint(TreeNode root){
            int m = (int)1e9+7;
            Queue<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);
            int ans = 0;
            while (!queue.isEmpty()){
                int count = queue.size();
                int tempAns = 0;
                while (count > 0){
                    TreeNode temp = queue.poll();
                    tempAns = (int)(((long)tempAns + temp.val)%m);
                    if (temp.left != null)
                        queue.add(temp.left);
                    if (temp.right != null)
                        queue.add(temp.right);
                    count--;
                }
                ans = Math.max(ans, tempAns);
            }
            return ans;
        }

    }

}
