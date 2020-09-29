package com.jd.structures.L03StacksandQueues.L02ArrayStack;

public interface Stack<E> {

  int getSize();

  boolean isEmpty();

  void push(E e);

  E pop();

  E peek();
}
