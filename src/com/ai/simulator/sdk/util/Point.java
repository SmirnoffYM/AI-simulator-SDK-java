package com.ai.simulator.sdk.util;

/**
 * Class represents a point on the map
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:37 PM
 */
public class Point {

    private int X;
    private int Y;

    public Point(int x, int y) {
        X = x;
        Y = y;
    }

    public int X() {
        return X;
    }

    public int Y() {
        return Y;
    }
}
