package com.nhnacademy.mylinkedlist;

import java.util.Iterator;

public class MyLinkedList<E> implements ILinkedList<E>, Iterable<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0; // linked list size

    // head <-- head --> head
    // data <-- data --> data
    // tail <-- tail --> tail

    @Override
    public void addFirst(E e) {
        Node<E> newHead = new Node<E>(e);
        newHead.setNext(head);
        head.setPrev(newHead);
    }

    @Override
    public void addLast(E e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addLast'");
    }

    @Override
    public E removeFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeFirst'");
    }

    @Override
    public E removeLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removeLast'");
    }

    @Override
    public E getFirst() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getFirst'");
    }

    @Override
    public E getLast() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLast'");
    }

    @Override
    public Iterator<E> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }

}
