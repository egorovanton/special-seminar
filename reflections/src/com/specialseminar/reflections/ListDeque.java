package com.specialseminar.reflections;

import java.util.Iterator;
import java.util.List;

/**
 * Created by Anton on 17.09.2017.
 */
public class ListDeque<E> implements Deque<E> {

    private class Node {
        E data;
        Node next;
        Node prev;

        Node(){}
        Node(E d, Node n, Node p){
            data = d;
            next = n;
            prev = p;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public ListDeque() {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }


    @Override
    public void addFirst(E elem) {
        size++;
        head.data = elem;
        head.prev = new Node(null, head, null);
        head = head.prev;
    }

    @Override
    public E first() {
        return head.next.data;
    }

    @Override
    public E removeFirst() {
        if (size == 0)
            return null;

        E result = first();

        size--;
        head = head.next;
        head.prev = null;
        head.data = null;

        return result;
    }

    @Override
    public void addLast(E elem) {
        size++;
        tail.data = elem;
        tail.next = new Node(null, null, tail);
        tail = tail.next;
    }

    @Override
    public E last() {
        return tail.prev.data;
    }

    @Override
    public E removeLast() {
        if (size == 0) {
            return null;
        }

        E result = last();

        size--;
        tail = tail.prev;
        tail.next = null;
        tail.data = null;

        return result;
    }

    private class ListDequeIterator implements Iterator<E> {

        Node currentHead = head;
        Node currentTail = tail;

        @Override
        public boolean hasNext() {
            return currentHead.next != currentTail;
        }

        @Override
        public E next() {
            currentHead = currentHead.next;
            return currentHead.data;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ListDequeIterator();
    }
}
