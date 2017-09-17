package com.specialseminar.reflections;

import javax.swing.text.html.HTMLDocument;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import static java.lang.Math.floorMod;
import static java.lang.Math.getExponent;
import static java.lang.Math.max;

/**
 * Created by Anton on 16.09.2017.
 */
public class ArrayDeque<E> implements Deque<E> {
    private static int MINIMUM_CAPACITY = 16;

    private Object buffer[];
    private int head;
    private int tail;


    public ArrayDeque() {
        buffer = new Object[MINIMUM_CAPACITY];
        head = 0;
        tail = 0;
    }

    private void enlarge() {
        Object newBuffer[] = new Object[buffer.length * 2];
        int size = size();
        for (int i = 0; i < size; ++i) {
            newBuffer[i] = buffer[(head + i) % buffer.length];
        }

        buffer = newBuffer;
        head = 0;
        tail = size;
    }

    public int size() {
        return tail > head ? tail - head : buffer.length - head + tail;
//        return (tail - head) & (buffer.length - 1);
    }

    @Override
    public void addFirst(E elem) {
        head = floorMod(head - 1, buffer.length);
        buffer[head] = elem;

        if (tail % buffer.length == head) {
            enlarge();
        }
    }

    @Override
    public E first() {
        return (E) buffer[head];
    }

    @Override
    public E removeFirst() {
        if (isEmpty()) {
            return null;
        }

        E first = first();
        head = (head + 1) % buffer.length;
        return first;
    }

    private boolean isEmpty() {
        return head == tail;
    }

    @Override
    public void addLast(E elem) {
        buffer[tail] = elem;
        tail = (tail + 1) % buffer.length;

        if (tail % buffer.length == head) {
            enlarge();
        }
    }

    @Override
    public E last() {
        return (E) buffer[floorMod(tail - 1, buffer.length)];
    }

    @Override
    public E removeLast() {
        if (isEmpty()) {
            return null;
        }

        E last = last();
        tail = floorMod(tail - 1, buffer.length);
        return last;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayDequeIterator();
    }

    private class ArrayDequeIterator implements Iterator<E> {

        private int currentHead = head;
        private int currentTail = tail;

        @Override
        public boolean hasNext() {
            return (currentHead != currentTail);
        }

        @Override
        public E next() {
            E result = (E) buffer[currentHead];
            currentHead = (currentHead + 1) % buffer.length;
            return result;
        }
    }
}
