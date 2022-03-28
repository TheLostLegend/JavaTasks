package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel{
    int actionLimit;
    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        this.actionLimit = actionLimit;
    }
    public CarouselRun run(){
        if (run) return null;
        run = true;
        return new CarouselRun(cap, mass, "decL", actionLimit);
    }
}
