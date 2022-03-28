package com.epam.rd.autotasks.arrays;

import java.util.Arrays;

public class LocalMaximaRemove {

    public static void main(String[] args) {
        int[] array = new int[]{18, 1, 3, 6, 7, -5};

        System.out.println(Arrays.toString(removeLocalMaxima(array)));
    }

    public static int[] removeLocalMaxima(int[] array){
        int i1 = 0;
        if (!(array[0] > array[1])) i1++;
        for (int i = 1; i<array.length-1; i++){
            if (!(array[i] > array[i-1]) || !(array[i] > array[i+1])) i1++;
        }
        if (!(array[array.length-1] > array[array.length-2])) i1++;

        int[] arr = new int[i1];
        i1 = 0;
        if (!(array[0] > array[1])) {arr[i1] = array[i1]; i1++;}
        for (int i = 1; i<array.length-1; i++){
            if (!(array[i] > array[i-1]) || !(array[i] > array[i+1])) {arr[i1] = array[i]; i1++;}
        }
        if (!(array[array.length-1] > array[array.length-2])) arr[i1] = array[array.length-1];
        return  arr;
    }
}
