package com.jd.structures.L08HeapandPriorityQueue.L06PriorityQueue;

public interface Queue<E> {

  int getSize();

  boolean isEmpty();

  void enqueue(E e);

  E dequeue();

  E getFront();
}
