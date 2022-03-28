package com.epam.rd.autotasks.figures;

class Circle extends Figure {
    Point mid;
    double rad;

    public Circle(Point point, double i) {
        mid = point;
        rad = i;
    }

    @Override
    public double area() {
        return Math.PI*rad*rad;
    }

    @Override
    public String pointsToString() {
        return "("+ mid.getX() +","+ mid.getY() +")";
    }

    @Override
    public String toString(){
        return "Circle[("+ mid.getX() +","+ mid.getY() +")"+ rad +"]";
    }

    @Override
    public Point leftmostPoint() {
        return new Point(this.mid.getX()-rad,this.mid.getY());
    }
}



