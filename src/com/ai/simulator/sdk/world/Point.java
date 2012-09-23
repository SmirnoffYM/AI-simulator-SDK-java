package com.ai.simulator.sdk.world;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return X == point.X && Y == point.Y;
    }

    @Override
    public int hashCode() {
        int result = X;
        result = 31 * result + Y;
        return result;
    }

    @Override
    public String toString() {
        return "[" + X + ", " + Y + "]";
    }
}
