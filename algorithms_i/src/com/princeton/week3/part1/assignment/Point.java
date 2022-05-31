package com.princeton.week3.part1.assignment;

import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public final class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public double slopeTo(Point that) {
        if (that == null)
            throw new NullPointerException();
        double x0 = (double) this.x;
        double y0 = (double) this.y;
        double x1 = (double) that.x;
        double y1 = (double) that.y;

        double numerator = y1 - y0;
        double denominator = x1 - x0;

        // points coincide
        if (x0 == x1 && y0 == y1) {
            return Double.NEGATIVE_INFINITY;
        }

        //horizontal line
        if (y0 == y1) {
            return +0.0;
        }

        // vertical line
        if (denominator == 0) {
            return Double.POSITIVE_INFINITY;
        }

        return numerator / denominator;
    }

    @Override
    public int compareTo(Point that) {
        if (this.y < that.y || (this.y == that.y && this.x < that.x)) {
            return -1;
        } else if (this.y > that.y || (this.y == that.y && this.x > that.x)) {
            return 1;
        }
        return 0;
    }

    public Comparator<Point> slopeOrder() {
//        return new Comparator<Point>() {
//            @Override
//            public int compare(Point p1, Point p2) {
//                if (slopeTo(p1) < slopeTo(p2)) {
//                    return -1;
//                } else if (slopeTo(p1) > slopeTo(p2)) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//
//            }
//        };

        return new SlopeComparator();
    }

    private class SlopeComparator implements Comparator<Point> {

        @Override
        public int compare(Point p1, Point p2) {
            if (p1 == null || p2 == null) {
                throw new NullPointerException();
            }
            return Double.compare(slopeTo(p1), slopeTo(p2));
        }
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public static void main(String[] args) {

    }
}
