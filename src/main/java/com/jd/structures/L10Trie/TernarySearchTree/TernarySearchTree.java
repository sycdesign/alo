package com.jd.structures.L10Trie.TernarySearchTree;

import java.util.ArrayList;

/**
 * @author: gaohongbin5
 * @date: 2020/9/24 21:10:58
 * @description: TernarySearchTree
 */
public class TernarySearchTree {

  private TSTNode root;

  private ArrayList<String> al;

  public TernarySearchTree() {
    root = null;
  }

  public boolean isEmpty() {
    return root == null;
  }

  public void makeEmpty() {
    root = null;
  }

  public void insert(String word) {
    root = insert(root, word.toCharArray(), 0);
  }

  public void delete(String word) {
    delete(root, word.toCharArray(), 0);
  }

  public boolean search(String word) {
    return search(root, word.toCharArray(), 0);
  }

  @Override
  public String toString() {
    al = new ArrayList<String>();
    traverse(root, "");
    return "\nTernary Search Tree : " + al;
  }

  private void traverse(TSTNode root, String str) {}

  private boolean search(TSTNode root, char[] toCharArray, int ptr) {
    return false;
  }

  private void delete(TSTNode root, char[] toCharArray, int ptr) {}

  private TSTNode insert(TSTNode root, char[] toCharArray, int ptr) {

    return null;
  }
}
