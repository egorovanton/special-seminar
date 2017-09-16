package com.specialseminar.decorators;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * Created by Anton on 16.09.2017.
 */
public class PrintableArraySequence<E> implements Sequence<E> {
    private ArrayList<E> elements = new ArrayList<>();

    PrintableArraySequence() {}
    PrintableArraySequence(E... collection) {
        Collections.addAll(elements, collection);
    }

    PrintableArraySequence(Collection<E> collection){
        elements.addAll(collection);
    }

    public void add(E e) {
        elements.add(e);
    }

    @Override
    public void print(String delimiter, PrintStream ps) {
        ps.print(elements.stream().map(Object::toString).collect(Collectors.joining(delimiter)));
    }

    @Override
    public int size() {
        return elements.size();
    }
}
