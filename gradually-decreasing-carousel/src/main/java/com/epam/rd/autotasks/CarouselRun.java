package com.epam.rd.autotasks;

public class CarouselRun {
    int[] mass, u;
    int i, cap, n;
    String mode;
    public CarouselRun(int capacity, int[] mass, String mode) {
        this.mass = mass;
        this.cap = capacity;
        i=0; n = 0;
        u = new int[mass.length];
        this.mode = mode;
    }

    public int next() {
        if (isFinished()) return -1;
        while (!(mass[i] > 0))   {
            i++;
            n++;
            if (n == cap) return -1;
            if (i == cap) {i = 0; n = 0;}
        }
        int k = mass[i];
        if (mode.equals("dec"))mass[i]--;
        else {u[i]++; mass[i]-=u[i]; if(mass[i]<0) mass[i] = 0;}
        i++;
        if (i == cap) {i = 0; n = 0;}
        return k;

    }

    public boolean isFinished() {
        int r = 0;
        for (int j = 0; j<cap; j++){
            if (mass[j] == 0) r++;
        }
        return r == cap;
    }

}