package com.jd.structures.L04LinkedList.L06ImplementStackinLinkedList;

public interface Stack<E> {

    int getSize();

    boolean isEmpty();

    void push(E e);

    E pop();

    E peek();
}
