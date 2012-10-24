package com.ai.simulator.sdk.agent;

import com.ai.simulator.sdk.world.Color;
import com.ai.simulator.sdk.world.Intersection;
import com.ai.simulator.sdk.world.Point;

/**
 * Some abstract object of the simulated world
 *
 * @author Smirnoff Y
 * @since 10/12/12 9:57 PM
 */
public abstract class Object {

    private Color color;
    private int size;
    private double orientation;
    private Intersection intersection;
    private Point coordinates;

    protected Object(Color color, int size, double orientation, Intersection intersection, Point coordinates) {
        this.color = color;
        this.size = size;
        this.orientation = orientation;
        this.intersection = intersection;
        this.coordinates = coordinates;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public double getOrientation() {
        return orientation;
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public Intersection getIntersection() {
        return intersection;
    }
}
