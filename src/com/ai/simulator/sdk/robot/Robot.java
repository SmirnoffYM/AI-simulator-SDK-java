package com.ai.simulator.sdk.robot;

import com.ai.simulator.sdk.world.Color;
import com.ai.simulator.sdk.world.Intersection;
import com.ai.simulator.sdk.world.Point;

import java.util.Map;

/**
 * Robot entity
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:35 PM
 */
public class Robot {

    private Color color;
    private int size;
    private double orientation;
    private Intersection intersection;
    private Point coordinates;
    private Map<String, Double> parameters;

    public Robot(Color color, int size, double orientation, Intersection intersection, Point coordinates,
                 Map<String, Double> parameters) {
        this.color = color;
        this.size = size;
        this.orientation = orientation;
        this.intersection = intersection;
        this.coordinates = coordinates;
        this.parameters = parameters;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public Double getParameter(String parameter) {
        return parameters.get(parameter);
    }

    public Point getCoordinates() {
        return coordinates;
    }

    public Intersection getIntersection() {
        return intersection;
    }

    public double getOrientation() {
        return orientation;
    }
}
