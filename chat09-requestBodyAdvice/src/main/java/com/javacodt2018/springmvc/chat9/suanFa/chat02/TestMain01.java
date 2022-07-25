package com.javacodt2018.springmvc.chat9.suanFa.chat02;

/**
 * @author crush
 */
public class TestMain01 {

    public static void main(String[] args) {
        int[] argList = new int[]{
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 0, 15, 16, 17, 18, 19, 20
        };
        System.out.println(getMin(argList));
        for (int i : getArray(argList)) {
            System.out.println("i = " + i);
        }
    }


    public static int getMin(int[] array) {
        int smallect = array[0];
        int smallest = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallect) {
                smallect = array[i];
                smallest = i;
            }
        }
        return smallest;
    }

    public static int[] getArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int i1 = i; i1 < array.length; i1++) {
                if (array[i] > array[i1]) {
                    int temp = array[i];
                    array[i] = array[i1];
                    array[i1] = temp;
                }
            }
        }
        return array;
    }

}
