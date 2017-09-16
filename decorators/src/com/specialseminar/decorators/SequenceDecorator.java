package com.specialseminar.decorators;

import java.io.PrintStream;

/**
 * Created by Anton on 16.09.2017.
 */
public abstract class SequenceDecorator<E> implements Sequence<E> {
    protected Sequence<E> sequence;

    public SequenceDecorator(Sequence<E> s) {
        sequence = s;
    }

    public void print(String delimiter, PrintStream ps) {
        sequence.print(delimiter, ps);
    }

    public int size() {
        return sequence.size();
    }
}
