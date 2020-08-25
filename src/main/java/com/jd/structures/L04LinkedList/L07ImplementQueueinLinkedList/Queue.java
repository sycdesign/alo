package com.jd.structures.L04LinkedList.L07ImplementQueueinLinkedList;

public interface Queue<E> {

    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
