package com.epam.rd.autotasks.triangle;

class Triangle {
    Point a, b, c;
    double a1, b1, c1;

    public Triangle(Point a, Point b, Point c) {
        a1 = length(a,b);
        b1 = length(c,b);
        c1 = length(c,a);
        if (!(a1 < b1 +c1 && b1 < a1 +c1 && c1< a1+b1)) throw new IllegalArgumentException();
        this.a = a;
        this.b = b;
        this.c = c;

    }

    public double area() {
        double p = (a1 + b1 + c1) / 2.0;
        return Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
    }

    public Point centroid(){
        return new Point((a.getX() + b.getX() + c.getX())/3,(a.getY() + b.getY() + c.getY())/3);
    }

    double length(Point start, Point end) {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }
}
