package com.jd.structures.L03StacksandQueues.L06LoopQueue;

public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
