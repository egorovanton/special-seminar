package com.specialseminar.decorators;

import java.io.PrintStream;

/**
 * Created by Anton on 16.09.2017.
 */
public class SequenceHeaderDecorator<E> extends SequenceDecorator<E> {
    private final String header;

    public SequenceHeaderDecorator(Sequence<E> s, String header) {
        super(s);
        this.header = header;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        ps.print(header);
        super.print(delimiter, ps);
    }
}
