package com.jd.lee.j0297;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String ret) {
        if (node == null){
            ret += "null,";
        }else{
            ret += node.val + ",";
            ret = dfs(node.left, ret);
            ret = dfs(node.right, ret);
        }
        return ret;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> res = new LinkedList<>(Arrays.asList(arr));
        return dfs(res);
    }

    private TreeNode dfs(List<String> vec) {
        if ("null".equals(vec.get(0))){
            vec.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(vec.get(0)));
        vec.remove(0);
        node.left = dfs(vec);
        node.right = dfs(vec);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode rleft = new TreeNode(4);
        TreeNode rright = new TreeNode(5);
        root.left = left;
        root.right = right;
        right.left = rleft;
        right.right = rright;

        String s = new Main3().serialize(root);
        System.out.println(s);

        TreeNode des = new Main3().deserialize(s);
        System.out.println(new Main3().serialize(des));

    }
}
