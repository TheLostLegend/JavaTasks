package com.epam.rd.autotasks.segments;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;
import static java.lang.StrictMath.pow;

class Segment {
    Point start;
    Point end;

    public Segment(Point start, Point end) {
        if (start.getX() == end.getX() && start.getY() == end.getY())
            throw new IllegalArgumentException();
        this.end = end;
        this.start = start;

    }

    double length() {
        double xDistanceSquare = Math.pow(start.getX() - end.getX(), 2);
        double yDistanceSquare = Math.pow(start.getY() - end.getY(), 2);
        return Math.sqrt(xDistanceSquare + yDistanceSquare);

    }

    Point middle() {
        return new Point( (start.getX() + end.getX()) / 2,
                (start.getY() + end.getY()) / 2 );

    }

    Point intersection(Segment another) {
        Point p1 = start;
        Point p2 = end;
        Point p3 = another.start;
        Point p4 = another.end;
        if (p2.getX() < p1.getX()) {

            Point tmp = p1;
            p1 = p2;
            p2 = tmp;
        }

        if (p4.getX() < p3.getX()) {

            Point tmp = p3;
            p3 = p4;
            p4 = tmp;
        }
        if((p1.getX() - p2.getX() == 0) && (p3.getX() - p4.getX() == 0)) {

            //если они лежат на одном X
            if(p1.getX() == p3.getX()) {

                //проверим пересекаются ли они, т.е. есть ли у них общий Y
                //для этого возьмём отрицание от случая, когда они НЕ пересекаются
                if (!((Math.max(p1.getY(), p2.getY()) < Math.min(p3.getY(), p4.getY())) ||
                        (Math.min(p1.getY(), p2.getY()) > Math.max(p3.getY(), p4.getY())))) {

                    return null;
                }
            }

            return null;
        }
        //если первый отрезок вертикальный
        if (p1.getX() - p2.getX() == 0) {

            //найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p1.getX();
            double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
            double b2 = p3.getY() - A2 * p3.getX();
            double Ya = A2 * Xa + b2;

            if (p3.getX() <= Xa && p4.getX() >= Xa && Math.min(p1.getY(), p2.getY()) <= Ya &&
                    Math.max(p1.getY(), p2.getY()) >= Ya) {

                return new Point(Xa, Ya);
            }

            return null;
        }
        //если второй отрезок вертикальный
        if (p3.getX() - p4.getX() == 0) {

            //найдём Xa, Ya - точки пересечения двух прямых
            double Xa = p3.getX();
            double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
            double b1 = p1.getY() - A1 * p1.getX();
            double Ya = A1 * Xa + b1;

            if (p1.getX() <= Xa && p2.getX() >= Xa && Math.min(p3.getY(), p4.getY()) <= Ya &&
                    Math.max(p3.getY(), p4.getY()) >= Ya) {

                return new Point(Xa, Ya);
            }

            return null;
        }
        //оба отрезка невертикальные
        double A1 = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        double A2 = (p3.getY() - p4.getY()) / (p3.getX() - p4.getX());
        double b1 = p1.getY() - A1 * p1.getX();
        double b2 = p3.getY() - A2 * p3.getX();

        if (A1 == A2) {
            return null; //отрезки параллельны
        }

//Xa - абсцисса точки пересечения двух прямых
        double Xa = (b2 - b1) / (A1 - A2);

        if ((Xa < Math.max(p1.getX(), p3.getX())) || (Xa > Math.min( p2.getX(), p4.getX()))) {
            return null; //точка Xa находится вне пересечения проекций отрезков на ось X
        }
        else {
            return new Point(Xa, Xa*A1 + b1);
        }


    }

}
