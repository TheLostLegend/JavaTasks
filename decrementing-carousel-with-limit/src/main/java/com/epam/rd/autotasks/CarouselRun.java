package com.epam.rd.autotasks;

public class CarouselRun {
    int[] mass, u;
    int i, cap, n, limit;
    String mode;
    public CarouselRun(int capacity, int[] mass, String mode) {
        this.mass = mass;
        this.cap = capacity;
        i=0; n = 0;
        u = new int[mass.length];
        this.mode = mode;
    }

    public CarouselRun(int capacity, int[] mass, String mode, int Limit) {
        this.mass = mass;
        this.cap = capacity;
        i=0; n = 0;
        u = new int[mass.length];
        this.mode = mode;
        this.limit = Limit;
    }

    public int next() {
        if (isFinished()) return -1;
        if (mode.equals("decL") && limit == 0) return -1;
        while (!(mass[i] > 0))   {
            i++;
            n++;
            if (n == cap) return -1;
            if (i == cap) {i = 0; n = 0;}
        }
        int k = mass[i];
        if (mode.equals("dec"))mass[i]--;
        else {mass[i]--; limit--;}
        i++;
        if (i == cap) {i = 0; n = 0;}
        return k;

    }

    public boolean isFinished() {
        if (mode.equals("decL") && limit == 0) return true;
        int r = 0;
        for (int j = 0; j<cap; j++){
            if (mass[j] == 0) r++;
        }
        return r == cap;
    }

}