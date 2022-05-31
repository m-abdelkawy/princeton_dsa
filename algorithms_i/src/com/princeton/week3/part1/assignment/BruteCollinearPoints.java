package com.princeton.week3.part1.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BruteCollinearPoints {
    private final LineSegment[] segments;

    public BruteCollinearPoints(Point[] points) {
        if (points == null) {
            throw new IllegalArgumentException();
        }
        Point[] pointsClone = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].equals(points[j])) {
                    throw new IllegalArgumentException();
                }
            }
            pointsClone[i] = points[i];
        }
        Arrays.sort(pointsClone);

        List<LineSegment> lineSegments = new ArrayList<>();
        int N = pointsClone.length;
        for (int i = 0; i < N - 3; i++) {
            for (int j = i + 1; j < N - 2; j++) {
                for (int k = j + 1; k < N - 1; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (pointsClone[i].slopeTo(pointsClone[j]) == pointsClone[i].slopeTo(pointsClone[k])
                                && pointsClone[i].slopeTo(pointsClone[j]) == pointsClone[i].slopeTo(pointsClone[l])) {
                            LineSegment seg = new LineSegment(pointsClone[i], pointsClone[l]);
                            if (!lineSegments.contains(seg))
                                lineSegments.add(seg);
                        }
                    }
                }
            }
        }
        segments = lineSegments.toArray(new LineSegment[lineSegments.size()]);
    }


    public int numberOfSegments() {
        return segments.length;
    }

    public LineSegment[] segments() {
        return segments.clone();
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In("D:\\dev\\princeton_dsa\\algorithms_i\\src\\com\\princeton\\week3\\part1\\assignment\\input\\input20.txt");
        int n = in.readInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.readInt();
            int y = in.readInt();
            points[i] = new Point(x, y);
        }

        // draw the points
        StdDraw.enableDoubleBuffering();
        StdDraw.setXscale(0, 32768);
        StdDraw.setYscale(0, 32768);
        for (Point p : points) {
            p.draw();
        }
        StdDraw.show();

        // print and draw the line segments
        BruteCollinearPoints collinear = new BruteCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        System.out.println("----------------------------");
        LineSegment[] seg = collinear.segments();
        for (int i = 0; i < seg.length; i++) {
            StdOut.println(seg[i]);
            //segment.draw();
        }

        StdDraw.show();
    }
}
