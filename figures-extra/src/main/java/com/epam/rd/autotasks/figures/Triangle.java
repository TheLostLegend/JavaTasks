package com.epam.rd.autotasks.figures;

class Triangle extends Figure {
    Point a,b,c;
    double a1, b1, c1;

    public Triangle(Point point, Point point1, Point point2) {
        a = point;
        b = point1;
        c = point2;
        if (a == null || b == null || c== null) throw new IllegalArgumentException();
        a1 = length(a,b);
        b1 = length(c,b);
        c1 = length(c,a);
        if (!(a1 + 0.0001 < b1 + c1 && b1 + 0.0001< a1 + c1 && c1+ 0.0001< a1 + b1)) throw new IllegalArgumentException();
    }

    public double area() {
        double p = (a1 + b1 + c1) / 2.0;
        return Math.sqrt(p * (p - a1) * (p - b1) * (p - c1));
    }

    public String pointsToString() {
        return "("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")";
    }

    @Override
    public String toString(){
        return "Triangle[("+ a.getX() +","+ a.getY() +")"+"("+ b.getX() +","+ b.getY() +")"+"("+ c.getX() +","+ c.getY() +")]";
    }

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

    @Override
    public Point centroid(){
        return new Point((a.getX() + b.getX() + c.getX())/3,(a.getY() + b.getY() + c.getY())/3);
    }

    @Override
    public boolean isTheSame(Figure figure) {
        if (!(this.getClass() == figure.getClass())) return false;
        Point[] basic1 = new Point[]{ a, b, c};
        Point[] basic2 = new Point[]{ ((Triangle) figure).a, ((Triangle) figure).b, ((Triangle) figure).c};
        bubbleSort(basic1);
        bubbleSort(basic2);
        if(isEqual(basic1[0].getX(),basic2[0].getX()) && isEqual(basic1[0].getY(),basic2[0].getY())
                && isEqual(basic1[1].getX(),basic2[1].getX()) && isEqual(basic1[1].getY(),basic2[1].getY())
                && isEqual(basic1[2].getX(),basic2[2].getX()) && isEqual(basic1[2].getY(),basic2[2].getY())) return true;
        else return false;
    }
    public static boolean isEqual(double d1, double d2) {
        return d1 == d2 || isRelativelyEqual(d1,d2);
    }

    private static boolean isRelativelyEqual(double d1, double d2) {
        return 0.0000001 > Math.abs(d1- d2) / Math.max(Math.abs(d1), Math.abs(d2));
    }

    public static void bubbleSort(Point[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j].getX() > arr[j + 1].getX()) {
                    Point tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
