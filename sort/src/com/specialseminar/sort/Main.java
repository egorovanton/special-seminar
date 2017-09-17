package com.specialseminar.sort;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        if (args.length == 0) {
            System.out.println("Please, pass method name as an argument");
            return;
        }

	    String methodName = args[0];
        Method method;
        try {
            method = SortingStation.class.getMethod(methodName, null);
        } catch (NoSuchMethodException e) {
            System.out.println("Method " + methodName + " not found");
            return;
        }

        SortingStation station = new SortingStation();
        System.out.println(station.print());
        method.invoke(station);
        System.out.println(station.print());



    }

}
