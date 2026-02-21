package edu.uoc.ds.adt;

import edu.uoc.ds.adt.util.Point;

public class SpiralGenerator {

    private SpiralGenerator() {
    }

    public static Point[] generate(double a, double b, double thetaMax, double step) {
        if (step <= 0) {
            throw new IllegalArgumentException("step must be > 0");
        }
        if (thetaMax < 0) {
            throw new IllegalArgumentException("thetaMax must be >= 0");
        }

        int n = (int) Math.floor(thetaMax / step) + 1;
        Point[] points = new Point[n];

        double theta = 0.0;
        for (int i = 0; i < n; i++) {
            double r = a + b * theta;
            double x = r * Math.cos(theta);
            double y = r * Math.sin(theta);
            points[i] = new Point(x, y);
            theta += step;
        }

        return points;
    }
}