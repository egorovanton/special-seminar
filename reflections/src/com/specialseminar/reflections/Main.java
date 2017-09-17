package com.specialseminar.reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

public class Main {

    private static String iterableToString (Iterable elements) {
        StringBuilder sb = new StringBuilder();
        for (Object e : elements) {
            sb.append(e);
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String className = args[0];
        Class dequeClass;
        Deque<Integer> deque;
        try {
            dequeClass = Class.forName("com.specialseminar.reflections."+className);
            deque = (Deque<Integer>) dequeClass.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("No class with name " + className + " found");
            return;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        Random rand = new Random();
        for (int i = 0; i < 100; ++i) {
            deque.addFirst(rand.nextInt(100));
        }

        int sum = 0;
        for (int i: deque) {
            sum += i;
        }

        System.out.println("Sum of the elements " + sum);
        try {
            Method size = dequeClass.getMethod("size", null);
            System.out.println("Number of elements " + size.invoke(deque));
        } catch (NoSuchMethodException e) {

        } catch (InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }


//        testDeque(ArrayDeque.class);
//        testDeque(ListDeque.class);
    }



    private static void testDeque(Class<?> eClass) {
        System.out.println("Testing array deque");

        try {
            Random rand = new Random();
            for (int k = 0; k < 500; ++k) {
                Deque<Integer> myDeque = (Deque<Integer>) eClass.newInstance();
                java.util.Deque<Integer> realDeque = new java.util.ArrayDeque<>();

                for (int option : rand.ints(50, 0, 4).toArray()) {
                    int r = rand.nextInt(100);
                    if (option == 0) {
                        myDeque.addFirst(r);
                        realDeque.addFirst(r);
                    }
                    if (option == 1) {
                        myDeque.addLast(r);
                        realDeque.addLast(r);
                    }
                    if (option == 2) {
                        myDeque.removeFirst();
                        if (!realDeque.isEmpty()) {
                            realDeque.removeFirst();
                        }
                    }
                    if (option == 3) {
                        myDeque.removeLast();
                        if (!realDeque.isEmpty()) {
                            realDeque.removeLast();
                        }
                    }
                }

                String myDequePrinted = iterableToString(myDeque);
                String realDequePrinted = iterableToString(realDeque);

                if (!myDequePrinted.equals(realDequePrinted)) {
                    System.out.println("Wrong test");
                    System.out.println("myDeque:   " + myDequePrinted);
                    System.out.println("realDeque: " + realDequePrinted);
                }
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }


        System.out.println("Finished testing array deque");
    }
}
