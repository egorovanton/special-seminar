package com.specialseminar.lists;

import java.util.Iterator;

/**
 * Created by Anton on 16.09.2017.
 */
public class CyclicList<E> implements CycList<E> {
    private class Node<E> {
        E data;
        Node<E> next;
        Node(E d, Node<E> n) {
            data = d;
            next = n;
        }
        Node(){}
    }

    private Node<E> head = new Node<>();
    private Node<E> tail = head;
    private int length = 0;


    public void addFirst(E data) {
        tail.next = new Node<>(data, head);
        tail = tail.next;
        length++;
    }

    @Override
    public void shift(int delta) {
        if (length == 0)
            return;

        delta %= length;
        for (int i = 0; i < delta; ++i) {
            tail.next = head.next;
            tail = tail.next;
            head.next = tail.next;
            tail.next = head;
        }
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            Node<E> current = head;

            @Override
            public boolean hasNext() {
                return current.next != head;
            }

            @Override
            public E next() {
                current = current.next;
                return current.data;
            }
        };
        return iterator;
    }
}
