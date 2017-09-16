package com.specialseminar.decorators;

public class Main {

    public static void main(String[] args) {
        Sequence<Integer> plainSequence = new PrintableArraySequence<>(1, 2, 3, 4, 5);
        plainSequence.print(", ", System.out);
        System.out.println();

        Sequence<Integer> bracedSequence = new SequenceBraceDecorator<>(plainSequence, "[", "]");
        bracedSequence.print(", ", System.out);
        System.out.println();

        Sequence<Integer> curlyBracedSecuence = new SequenceBraceDecorator<>(plainSequence, "{ ", " }");
        curlyBracedSecuence.print(", ", System.out);
        System.out.println();

        Sequence<Integer> withHeaderAndLength = new SequenceLengthDecorator<>(
                new SequenceHeaderDecorator<>(plainSequence, "Элементы: "), " всего ", " элементов");
        withHeaderAndLength.print(";", System.out);
        System.out.println();

        Sequence<Integer> curlyBracedWithHeader = new SequenceHeaderDecorator<>(curlyBracedSecuence, "Элементы: ");
        curlyBracedWithHeader.print(", ", System.out);
        System.out.println();

    }
}
