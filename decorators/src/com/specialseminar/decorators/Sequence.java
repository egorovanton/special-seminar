package com.specialseminar.decorators;

import java.io.PrintStream;

/**
 * Created by Anton on 16.09.2017.
 */
public interface Sequence<E> {
    void print(String delimiter, PrintStream ps);
    int size();
}
