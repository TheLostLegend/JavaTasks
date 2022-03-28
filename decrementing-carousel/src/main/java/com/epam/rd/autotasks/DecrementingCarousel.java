package com.epam.rd.autotasks;

public class DecrementingCarousel {
    Boolean run = false;
    int[] mass;
    int i, cap;
    public DecrementingCarousel(int capacity) {
        mass = new int[capacity];
        i=0; cap = capacity;

    }

    public boolean addElement(int element){
        if (run || element <= 0 || i == cap) return false;
        mass[i] = element;
        i++;
        return true;
    }

    public CarouselRun run(){
       if (run) return null;
       run = true;
       return new CarouselRun(cap, mass);
    }
}
