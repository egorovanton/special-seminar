package com.specialseminar.decorators;

import java.io.PrintStream;

/**
 * Created by Anton on 16.09.2017.
 */
public class SequenceBraceDecorator<E> extends SequenceDecorator<E> {
    private final String leftBrace;
    private final String rightBrace;

    public SequenceBraceDecorator(Sequence<E> s, String left, String right) {
        super(s);
        leftBrace = left;
        rightBrace = right;
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        ps.print(leftBrace);
        super.print(delimiter, ps);
        ps.print(rightBrace);
    }
}
