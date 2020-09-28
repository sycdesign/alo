package com.jd.structures.L10Trie.suffixTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: gaohongbin5
 * @date: 2020/9/25 15:57:33
 * @description: Node
 */
public class Node {
    private String text;
    private List<Node> children;
    private int position;

    public Node(String word, int position) {
        this.text = word;
        this.position = position;
        this.children = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
