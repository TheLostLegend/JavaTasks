package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    Point a,b,c;
    double a1, b1, c1;

    public Triangle(Point point, Point point1, Point point2) {
        a = point;
        b = point1;
        c = point2;
        a1 = length(a,b);
        b1 = length(c,b);
        c1 = length(c,a);
    }

    @Override
    public double area() {
        double p = (a1 + b1 + c1) / 2.0;
        return Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
    }

    @Override
    public String pointsToString() {
        return "("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")";
    }

    @Override
    public String toString(){
        return "Triangle[("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")]";
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX())
            return a;
        if (b.getX() <= a.getX() && b.getX() <= c.getX())
            return b;
        if (c.getX() <= b.getX() && c.getX() <= a.getX())
            return c;
        return a;
    }

    double length(Point start, Point end) {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }
}
