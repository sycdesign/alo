package com.jd.structures.L03StacksandQueues.L04MoreaboutLeetcode;

public interface Stack<E> {

  int getSize();

  boolean isEmpty();

  void push(E e);

  E pop();

  E peek();
}
