package com.epam.rd.autotasks.intersection;

public class Line {
    int point1;
    int point2;

    public Line(int k, int b) {
        point1 = k;
        point2 = b;

    }

    public Point intersection(Line other) {
        int m1 = this.point1;
        int m2 = other.point1;
        int b2 = other.point2;
        int b1 = this.point2;
        if (m1 == m2) {
            return null;
        }

        int x = (b2 - b1) / (m1 - m2);
        int y = m1 * x + b1;

        return new Point(x,y);



    }

}
