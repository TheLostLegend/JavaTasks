package com.epam.rd.autotasks;

class CycleSwap {
    static void cycleSwap(int[] array) {
        cycleSwap(array, 1);
    }

    static void cycleSwap(int[] array, int shift) {
        if (!(array.length == 0)) {
            int [] arr = new int[array.length];
            System.arraycopy(array, array.length-shift, arr, 0, shift);
            System.arraycopy(array, 0, arr, shift, array.length-shift);
            System.arraycopy(arr, 0, array, 0, array.length);
        }
    }
}
