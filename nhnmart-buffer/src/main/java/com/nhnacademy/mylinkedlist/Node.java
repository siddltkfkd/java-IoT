package com.nhnacademy.mylinkedlist;

public class Node<E> {
    private E data;
    private Node<E> next;
    private Node<E> prev;

    public Node(E e) {
        this.data = e;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node<E> getNext() {
        return next;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public Node<E> getprev() {
        return prev;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }
}
