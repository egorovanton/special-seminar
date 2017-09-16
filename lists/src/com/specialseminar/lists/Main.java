package com.specialseminar.lists;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

public class Main {
    private static final int ITERATIONS = 500;
    private static final int LENGTH = 50;


    public static void main(String[] args) {
        testSort();
        testSwap();
        testEquals();

    }

    private static String iterableToString(Iterable elements) {
        StringBuilder sb = new StringBuilder();
        for(Object e: elements) {
            sb.append(e.toString());
            sb.append(" ");
        }

        return sb.toString();
    }

    static <E> boolean listsEqual(CycList<E> list1, CycList<E> list2) {
        Iterator<E> iterator = list2.iterator();

        for (; iterator.hasNext(); iterator.next()) {
            Iterator<E> iter1 = list1.iterator();
            Iterator<E> iter2 = list2.iterator();
            boolean flag = true;
            while(iter1.hasNext() && iter2.hasNext()) {
                E data1 = iter1.next();
                E data2 = iter2.next();
                if (!data1.equals(data2)) {
                    flag = false;
                    break;
                }
            }
            flag &= !(iter1.hasNext() || iter2.hasNext());
            if (flag) {
                return true;
            }

            list2.shift(1);
        }
        return false;
    }


    private static void testEquals() {
        System.out.println("Testing equals");

        Random rand = new Random();
        CyclicList<Integer> list1 = new CyclicList<>();
        CyclicList<Integer> list2 = new CyclicList<>();

        for (int k = 0; k < ITERATIONS; ++k) {
            for (int i = 0; i < LENGTH; ++i) {
                int r = rand.nextInt(LENGTH);
                list1.addFirst(r);
                list2.addFirst(r);
            }
            for (int i = 0; i < LENGTH; ++i) {
                int shift1 = rand.nextInt(LENGTH * 3);
                int shift2 = rand.nextInt(LENGTH);

                list1.shift(shift1);
                list2.shift(shift2);
                if (!listsEqual(list1, list2)) {
                    System.out.println("Wrong test!");
                    System.out.println("shift1 = " + shift1 + ", and shift2 = " + shift2);
                    System.out.println("List1: " + iterableToString(list1));
                    System.out.println("List2: " + iterableToString(list2));
                }
            }

        }

        System.out.println("Testing equals finished");
    }



    private static void testSwap() {
        System.out.println("Testing swap");

        Random rand = new Random();
        for (int k = 0; k < ITERATIONS; k++) {
            List<Integer> list = new List<>();
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < LENGTH; i++) {
                int r = rand.nextInt(LENGTH);
                list.addFirst(r);
                arrayList.add(r);
            }
            Collections.reverse(arrayList);

            for (int i = 0; i < LENGTH; ++i) {
                int x = rand.nextInt(LENGTH);
                int y = rand.nextInt(LENGTH);

                list.swap(x, y);
                Collections.swap(arrayList, x, y);

                String printedList = list.print();
                String printedArrayList = iterableToString(arrayList);

                if (!printedList.equals(printedArrayList)) {
                    System.out.println("Wrong test!");
                    System.out.println("Swapping x = " + x + " and y = " + y);
                    System.out.println("My list");
                    System.out.println(printedList);
                    System.out.println("Actual list");
                    System.out.println(printedArrayList);
                }
            }
        }


        System.out.println("Testing swap finished");
    }

    private static void testSort() {
        System.out.println("Testing sort");

        Random rand = new Random();
        for (int k = 0; k < ITERATIONS; ++k) {
            List<Integer> list = new List<>();
            ArrayList<Integer> arrayList = new ArrayList<>();

            for (int i = 0; i < LENGTH; ++i) {
                int j = rand.nextInt(LENGTH);
                list.addFirst(j);
                arrayList.add(j);
            }
            list.sort();
            arrayList.sort(Integer::compare);

            String printedList = list.print();
            String printedArrayList = iterableToString(arrayList);
            if (!printedList.equals(printedArrayList)) {
                System.out.println("Wrong test!");
                System.out.println("My sort:");
                System.out.println(printedList);
                System.out.println("Actual sort:");
                System.out.println(printedArrayList);
            }
        }

        System.out.println("Testing sort finished");
    }
}
