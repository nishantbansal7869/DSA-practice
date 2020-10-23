package com.practice.interviewbit.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReverseLevelOrder {
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
         int maxD;
        public ArrayList<Integer> solve(TreeNode root) {
            ArrayList<Integer> ans = new ArrayList<>();
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            levelOrder(root, 0, map);
            while (maxD >= 0){
                if (map.containsKey(maxD))
                    for (int i : map.get(maxD))
                        ans.add(i);
                maxD--;
            }
            return ans;
        }
        private void levelOrder(TreeNode root, int d, Map<Integer, ArrayList<Integer>> map) {
            if(root == null)
                return;
            if (!map.containsKey(d))
                map.put(d, new ArrayList<>());
            ArrayList<Integer> list = map.get(d);
            list.add(root.val);
            map.put(d, list);
            maxD = Math.max(d, maxD);
            levelOrder(root.left, d+1,map);
            levelOrder(root.right, d+1, map);
        }
    }

}
