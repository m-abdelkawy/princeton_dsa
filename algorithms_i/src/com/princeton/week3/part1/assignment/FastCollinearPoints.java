package com.princeton.week3.part1.assignment;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class FastCollinearPoints {
    private final List<LineSegment> segments;

    public FastCollinearPoints(Point[] points) {
        segments = new ArrayList<>();

        if (points == null) {
            throw new IllegalArgumentException();
        }
        int N = points.length;

        Point[] pointCopy = new Point[N];
        for (int i = 0; i < N; i++) {
            if (points[i] == null) {
                throw new IllegalArgumentException();
            }
            for (int j = i + 1; j < N; j++) {
                if (points[i].equals(points[j])) {
                    throw new IllegalArgumentException();
                }
            }
            pointCopy[i] = points[i];
        }


        for (Point p: points) {
            Arrays.sort(pointCopy, p.slopeOrder());
            double slope = p.slopeTo(pointCopy[0]);
            int count = 1;
            // i for origin points (start point of a line segment)
            int i;
            for (i = 1; i < N; i++) {
                if(p.slopeTo(pointCopy[i]) == slope){
                    count++;
                }
                else{
                    if(count >= 3){
                        Arrays.sort(pointCopy, i-count, i);
                        if(p.compareTo(pointCopy[i-count])<0){
                            segments.add(new LineSegment(p, pointCopy[i-1]));
                        }
                    }
                    slope = p.slopeTo(pointCopy[i]);
                    count = 1;
                }
            }
            if(count >= 3){
                Arrays.sort(pointCopy, i-count, i);
                if(p.compareTo(pointCopy[i-count])<0){
                    segments.add(new LineSegment(p, pointCopy[i-1]));
                }
            }
        }
    }


    public int numberOfSegments() {
        return segments.size();
    }

    public LineSegment[] segments() {
        return segments.toArray(new LineSegment[segments.size()]);
    }

    public static void main(String[] args) {
        // read the n points from a file
        In in = new In("D:\\dev\\princeton_dsa\\algorithms_i\\src\\com\\princeton\\week3\\part1\\assignment\\input\\input8.txt");
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
        FastCollinearPoints collinear = new FastCollinearPoints(points);
        for (LineSegment segment : collinear.segments()) {
            StdOut.println(segment);
            segment.draw();
        }
        StdDraw.show();
    }
}
