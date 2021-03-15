package com.jd.lee.j0111;

import com.jd.lee.j0105.Main;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int minDepth(TreeNode root) {
        if ( null == root){
            return 0;
        }
        if (null == root.left && null == root.right){
            return 1;
        }
        int minDepth = Integer.MAX_VALUE;
        if (null != root.left){
            minDepth = Math.min(minDepth(root.left),minDepth);
        }
        if (null != root.right){
            minDepth = Math.min(minDepth(root.right),minDepth);
        }

        return minDepth + 1;
    }
}