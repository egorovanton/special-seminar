package com.specialseminar.reflections;

/**
 * Created by Anton on 16.09.2017.
 */
public interface Deque<E> extends Iterable<E> {
    void addFirst(E elem);   // Добавляет элемент в начало очереди.
    E first();               // Выдает первый элемент очереди.
    E removeFirst();         // Удаляет первый элемент из очереди
    // (и выдает его).
    void addLast(E elem);    // Добавляет элемент в конец очереди.
    E last();                // Выдает последний элемент очереди.
    E removeLast();          // Удаляет последний элемент из очереди
    // (и выдает его).
}
