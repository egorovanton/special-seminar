package com.specialseminar.lists;

/**
 * Created by Anton on 16.09.2017.
 */
public interface CycList<E> extends Iterable<E> {
    void shift(int delta);
}
