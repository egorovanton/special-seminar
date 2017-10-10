package com.specialseminar.lists;

import static java.lang.Math.min;
import static java.lang.Math.max;

/**
 * Created by Anton on 13.09.2017.
 */
public class List<E extends Comparable<E>> {
    private static class Node<E> {
        E data;
        Node<E> next;
        Node(E d, Node<E> n) {
            data = d;
            next = n;
        }

        Node() {}
    }

    private int length = 0;
    private Node<E> head = null;

    public void addFirst(E e) {
        head = new Node<>(e, head);
        length++;
    }

    public int size() {
        return length;
    }

    public void swap(int i, int j) {
        if (i < 0 || j < 0 || length <= i || length <= j) {
            throw new IndexOutOfBoundsException();
        }

        int a = min(i, j);
        int b = max(i, j);


        Node<E> current = new Node<>(null, head);
        Node<E> beforeA = current, beforeB = current;
        int k = -1;
        while (current != null) {
            if (k + 1 == a) {
                beforeA = current;
            }

            if (k + 1 == b) {
                beforeB = current;
                break;
            }

            current = current.next;
            k++;
        }

        Node<E> elementA = beforeA.next;
        Node<E> elementB = beforeB.next;
        beforeA.next = elementB;
        beforeB.next = elementA;

        Node<E> temp = elementA.next;
        elementA.next = elementB.next;
        elementB.next = temp;


        if (a == 0)
            head = elementB;

    }

    private void addAll(List<E> list) {
        if (head == null) {
            head = list.head;
            return;
        }

        Node<E> current = head;
        while(current.next != null) {
            current = current.next;
        }

        current.next = list.head;
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        Node<E> current = head;
        while(current != null) {
            builder.append(current.data).append(" ");
            current = current.next;
        }

        return builder.toString();
    }

    public void sort() {
        if (length <= 1) {
            return;
        }

        Tuple<List<E>, List<E>, List<E>> tuple = partition(head.data);
        List<E> smaller = tuple.getFirst();
        List<E> equal = tuple.getSecond();
        List<E> bigger = tuple.getThird();

        smaller.sort();
        bigger.sort();
        equal.addAll(bigger);
        smaller.addAll(equal);
        head = smaller.head;

    }

    private Tuple<List<E>, List<E>, List<E>> partition(E pivot) {
        Node<E> current = head;
        Node<E> smaller = null, equal = null, bigger = null;
        int smallerLen = 0, equalLen = 0, biggerLen = 0;

        while (current !=  null) {
            Node<E> next = current.next;

            if (current.data.compareTo(pivot) < 0) {
                current.next = smaller;
                smaller = current;
                smallerLen++;
            }

            if (current.data.compareTo(pivot) == 0) {
                current.next = equal;
                equal = current;
                equalLen++;
            }

            if (current.data.compareTo(pivot) > 0) {
                current.next = bigger;
                bigger = current;
                biggerLen++;
            }

            current = next;
        }

        List<E> smallerList = new List<>();
        List<E> equalList = new List<>();
        List<E> biggerList = new List<>();

        smallerList.head = smaller;
        equalList.head = equal;
        biggerList.head = bigger;

        smallerList.length = smallerLen;
        equalList.length = equalLen;
        biggerList.length = biggerLen;

        return new Tuple<>(smallerList, equalList, biggerList);
    }
}
