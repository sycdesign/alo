package com.jd.lee.j0297;

import java.util.*;

public class Main2 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (null == root){
            return "[null]";
        }
        
        String ret = "[";
        ret = dfs(root, ret);
        ret = ret.substring(0,ret.length()-1);
        return ret + "]";
    }

    private String dfs(TreeNode node, String ret) {

        ret += node.val + ",";

        if (null != node.left){
            ret = dfs(node.left, ret);

        }else{
            ret += "null,";
        }

        if (null != node.right){
            ret = dfs(node.right, ret);
        }else{
            ret += "null,";
        }
        return ret;
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        List<String> list = convertList(data);

        if (list.size() == 0 || list.size() == 1 && "null".equals(list.get(0))){
            return null;
        }
        return dfs(list);
    }

    private TreeNode dfs(List<String> vec) {
        if (index == vec.size() || "null".equals(vec.get(index))){
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vec.get(index)));
        index ++;
        node.left = dfs(vec);

        index ++;
        node.right = dfs(vec);
        return node;
    }

    private List<String> convertList(String data) {
        String s = data.substring(1, data.length() -1);
        String[] arr = s.split(",");
        List<String> res = new ArrayList<>(Arrays.asList(arr));
        return res;
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

        String s = new Main2().serialize(root);
        System.out.println(s);

        TreeNode des = new Main2().deserialize(s);
        System.out.println(new Main2().serialize(des));

    }
}
