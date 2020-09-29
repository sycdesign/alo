package com.jd.structures.L03StacksandQueues.L05ArrayQueue;

public interface Queue<E> {

  int getSize();

  boolean isEmpty();

  void enqueue(E e);

  E dequeue();

  E getFront();
}
