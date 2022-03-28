package com.epam.rd.autotasks;

public class HalvingCarousel extends DecrementingCarousel {

    public HalvingCarousel(final int capacity) {
        super(capacity);
    }

    public CarouselRun run(){
        if (run) return null;
        run = true;
        return new CarouselRun(cap, mass, "hal");
    }

}
