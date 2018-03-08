package com.company;

/**
 * Created by jack on 2015/5/16.
 */

//构造函数

public class Sphere {
    static final double PI = 3.14;
    static int count = 0;

    double radius;

    double xCenter;
    double yCenter;
    double zCenter;

    Sphere(double theRadius, double x, double y, double z) {
        radius = theRadius;
        xCenter = x;
        yCenter = y;
        zCenter = z;
        ++count;
    }

    static int getCount() {
        return count;
    }

    double volume() {
        return 4.0 / 3.0 * PI * radius * radius * radius;
    }
}
