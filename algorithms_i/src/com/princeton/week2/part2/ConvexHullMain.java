package com.princeton.week2.part2;
import edu.princeton.cs.algs4.Point2D;

import java.util.Arrays;
import java.util.Stack;

public class ConvexHullMain {
    public static void main(String[] args) {
        Stack<Point2D> hull = new Stack<>();

        Point2D[] p = new Point2D[] { new Point2D(0, 0), new Point2D(1, 1), new Point2D(1, 2), new Point2D(-1, 1),
                new Point2D(-1, 2), new Point2D(-2, 1), new Point2D(-3, 0), new Point2D(-1, -1) };
        Arrays.sort(p, Point2D.Y_ORDER);
        Arrays.sort(p, p[0].polarOrder());

        hull.push(p[0]);
        hull.push(p[1]);

        for (int i = 2; i < p.length; i++) {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, p[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(p[i]);
        }
    }
}
