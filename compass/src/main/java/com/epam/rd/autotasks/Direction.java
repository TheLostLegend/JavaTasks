package com.epam.rd.autotasks;

import java.util.Optional;

public enum Direction {
    N(0), NE(45), E(90), SE(135), S(180), SW(225), W(270), NW(315);

    Direction(final int degrees) {
        this.degrees = degrees;
    }

    private final int degrees;

    public static Direction ofDegrees(int degrees) {
        degrees+= 360;
        degrees = degrees%360;
        switch (degrees){
            case (0): return Direction.N;
            case (45): return Direction.NE;
            case (90): return Direction.E;
            case (135): return Direction.SE;
            case (180): return Direction.S;
            case (225): return Direction.SW;
            case (270): return Direction.W;
            case (315): return Direction.NW;
            default: return null;
        }
    }

    public static Direction closestToDegrees(int degrees) {
        degrees+= 360;
        degrees = degrees%360;
        int deg1 = degrees/45;
        int deg2 = degrees%45;
        if(deg2 <= 23) return ofDegrees(45*deg1);
        else return ofDegrees(45*(deg1+1));

    }

    public Direction opposite() {
        switch (this.degrees){
            case (0): return Direction.S;
            case (45): return Direction.SW;
            case (90): return Direction.W;
            case (135): return Direction.NW;
            case (180): return Direction.N;
            case (225): return Direction.NE;
            case (270): return Direction.E;
            case (315): return Direction.SE;
            default: return null;
        }
    }

    public int differenceDegreesTo(Direction direction) {
        int result;
        if (this.degrees > direction.degrees) result = this.degrees - direction.degrees;
        else result = direction.degrees - this.degrees;
        if (result > 180) result = 360-result;
        return result;
    }
}
