package com.jd.structures.L10Trie.TernarySearchTree;

/**
 * @author: gaohongbin5
 * @date: 2020/9/24 21:07:48
 * @description: TSTNode
 */
public class TSTNode {

    char data;

    boolean isEnd;

    TSTNode left, middle, right;

    public TSTNode(char data){
        this.data = data;
        this.isEnd = false;
        this.left = null;
        this.middle = null;
        this.right = null;
    }
}
