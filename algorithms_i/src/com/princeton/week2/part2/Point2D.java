package com.princeton.week2.part2;

public class Point2D {
    private final double x;
    private final double y;

    public Point2D(double _x, double _y) {
        this.x = _x;
        this.y = _y;
    }

    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
        if (area2 < 0)
            return -1; // clockwise
        else if (area2 > 0)
            return 1;// counter Clockwise
        else
            return 0; // Collinear
    }

    public static void main(String[] args) {

    }
}
