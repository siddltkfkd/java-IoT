package com.nhnacademy.mylinkedlist;

public interface IList<E> {
    boolean add(E element);

    boolean remove(int index);

    boolean remove(E e);

    E get(int index);

    E set(int index, E element);

    int indexOf(Object element);

    int size();

    boolean contains(Object o);
}
