package com.specialseminar.sort;

import java.util.Random;

/**
 * Created by Anton on 17.09.2017.
 */
public class SortingStation {
    private int[] elements;

    public SortingStation() {
        randomize();
    }

    public void randomize() {
        elements = new Random().ints(20, 0, 10).toArray();
    }

    public void bubbleSort() {
        boolean flag = false;
        do {
            flag = false;
            for (int i = 0; i < elements.length - 1; i++) {
                if (elements[i] > elements[i + 1]) {
                    int tmp = elements[i];
                    elements[i] = elements[i + 1];
                    elements[i + 1] = tmp;
                    flag = true;
                }
            }
        } while (flag);
    }

    public void insertSort(){
        for(int i = 1; i < elements.length; i++){
            int value = elements[i];
            int j = i - 1;
            while(j >= 0 && elements[j] > value){
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = value;
        }
    }

    public void countingSort(){
        int min = 0;
        int max = 9;

        int[] count = new int[max - min + 1];
        for(int number : elements){
            count[number - min]++;
        }

        for(int i = min, j = 0; i <= max; i++){
            while(count[i - min] > 0){
                elements[j]= i;
                j++;
                count[i - min]--;
            }
        }
    }


    public String print() {
        StringBuilder sb = new StringBuilder();
        for (int i : elements) {
            sb.append(i).append(" ");
        }
        return sb.toString();
    }
}
