package com.epam.rd.autotasks.figures;

class Quadrilateral extends Figure {
    Point a,b,c,d;
    double a1, b1, c1, d1, d2;

    public Quadrilateral(Point point, Point point1, Point point2, Point point3) {
        a = point;
        b = point1;
        c = point2;
        a1 = length(a,b);
        b1 = length(c,b);
        c1 = length(c,a);

        d = point3;
        d1 = length(c,d);
        d2 = length(a,d);
    }

    @Override
    public double area() {
        double p = (a1 + b1 + c1) / 2.0;
        double _p = (c1 + d1 + d2) / 2.0;
        return Math.sqrt(p * (p - a1) * (p - b1) * (p - c1)) + Math.sqrt(_p * (_p - d1) * (_p - d2) * (_p - c1));
    }

    @Override
    public String pointsToString() {
        return "("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")"+"("+ d.getX() +","+ d.getY() +")";
    }

    public String toString(){
        return "Quadrilateral[("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")"+"("+ d.getX() +","+ d.getY() +")]";
    }

    @Override
    public Point leftmostPoint() {
        if (a.getX() <= b.getX() && a.getX() <= c.getX() && a.getX() <= d.getX())
            return a;
        if (b.getX() <= a.getX() && b.getX() <= c.getX() && b.getX() <= d.getX())
            return b;
        if (c.getX() <= b.getX() && c.getX() <= a.getX() && c.getX() <= d.getX())
            return c;
        if (d.getX() <= b.getX() && d.getX() <= a.getX() && d.getX() <= c.getX())
            return d;
        return a;
    }

    double length(Point start, Point end) {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);
    }
}
