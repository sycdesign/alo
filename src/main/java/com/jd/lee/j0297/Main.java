package com.jd.lee.j0297;

import com.jd.lee.j0226.Solution1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
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
        
        if (null == root){
            return "[null]";
        }
        
        String ret = "[";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        ret += root.val;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();

            if (cur.left != null){
                ret += "," + cur.left.val;
                q.add(cur.left);
            }else{
                ret += ",null";
            }

            if (cur.right != null){
                ret += "," + cur.right.val;
                q.add(cur.right);
            }else{
                ret +=",null";
            }
        }
        return ret + "]";
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        List<String> list = convertList(data);

        if (list.size() == 0 || list.size() == 1 && "null".equals(list.get(0))){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int index = 1;
        while (!q.isEmpty()){
            TreeNode cur = q.poll();
            assert list.size() - index >=2;
            if (!"null".equals(list.get(index))){
                cur.left = new TreeNode(Integer.parseInt(list.get(index)));
                q.add(cur.left);
            }
            index ++;

            if (!"null".equals(list.get(index))){
                cur.right = new TreeNode(Integer.parseInt(list.get(index)));
                q.add(cur.right);
            }

            index ++;
        }
        return root;
    }

    private List<String> convertList(String data) {
        String s = data.substring(1, data.length() -1);
        List<String> res = new ArrayList<>();

        String[] arr = s.split(",");
        for (String a : arr) {
            res.add(a);
        }
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

        String s = new Main().serialize(root);
        System.out.println(s);

        TreeNode des = new Main().deserialize(s);
        System.out.println(new Main().serialize(des));

    }
}
