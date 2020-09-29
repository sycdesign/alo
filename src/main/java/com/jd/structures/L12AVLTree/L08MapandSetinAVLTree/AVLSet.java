package com.jd.structures.L12AVLTree.L08MapandSetinAVLTree;

// 07SetandMap.L01SetBasicsandBSTSet.Set;
// 14HashTable.L05HashTableImplementation.AVLTree;

public class AVLSet<E extends Comparable<E>> implements Set<E> {

  private AVLTree<E, Object> avl;

  public AVLSet() {
    avl = new AVLTree<>();
  }

  @Override
  public int getSize() {
    return avl.getSize();
  }

  @Override
  public boolean isEmpty() {
    return avl.isEmpty();
  }

  @Override
  public void add(E e) {
    avl.add(e, null);
  }

  @Override
  public boolean contains(E e) {
    return avl.contains(e);
  }

  @Override
  public void remove(E e) {
    avl.remove(e);
  }
}
