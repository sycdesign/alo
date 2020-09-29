package com.jd.structures.L10Trie.suffixTree;

/**
 * @author: gaohongbin5
 * @date: 2020/9/25 16:00:34
 * @description: SuffixTree
 */
public class SuffixTree {
  private static final String WORD_TERMINATION = "$";
  private static final int POSITION_UNDEFINED = -1;
  private Node root;
  private String fullText;

  public SuffixTree(String text) {
    root = new Node("", POSITION_UNDEFINED);
    fullText = text;
  }

  private void addChildNode(Node parentNode, String text, int index) {
    parentNode.getChildren().add(new Node(text, index));
  }
}
