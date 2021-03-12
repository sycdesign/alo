package com.jd.lee.j0226;

import java.util.LinkedList;

public class Solution1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode invertTree(TreeNode root){

        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public TreeNode invertTree1(TreeNode root) {

        if(root == null)
            return null;

        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.addLast(root);
        while(!queue.isEmpty()){
            TreeNode curNode = queue.removeFirst();

            TreeNode tempNode = curNode.left;
            curNode.left = curNode.right;
            curNode.right = tempNode;

            if(curNode.left != null)
                queue.addLast(curNode.left);
            if(curNode.right != null)
                queue.push(curNode.right);
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(7);
        root.left = left;
        root.right = right;


        TreeNode node = new Solution1().invertTree(root);

    }
}
