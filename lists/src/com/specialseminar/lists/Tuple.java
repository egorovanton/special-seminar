package com.specialseminar.lists;

/**
 * Created by Anton on 14.09.2017.
 */
public class Tuple<A, B, C> {
    private final A first;
    private final B second;
    private final C third;

    Tuple(A a, B b, C c) {
        first = a;
        second = b;
        third = c;
    }


    public A getFirst() {
        return first;
    }

    public B getSecond() {
        return second;
    }

    public C getThird() {
        return third;
    }
}
