package com.specialseminar.decorators;

import java.io.PrintStream;

/**
 * Created by Anton on 16.09.2017.
 */
public class SequenceLengthDecorator<E> extends SequenceDecorator<E> {
    private final String beforeNumber;
    private final String afterNumber;

    public SequenceLengthDecorator(Sequence<E> s, String beforeNumber, String afterNumber) {
        super(s);
        this.beforeNumber = beforeNumber;
        this.afterNumber = afterNumber;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        super.print(delimiter, ps);
        ps.print(beforeNumber);
        ps.print(size());
        ps.print(afterNumber);
    }
}
