package com.ai.simulator.sdk.agent;

import com.ai.simulator.sdk.world.Color;
import com.ai.simulator.sdk.world.Intersection;
import com.ai.simulator.sdk.world.Point;
import com.ai.simulator.sdk.world.RobotType;

import java.util.Map;

/**
 * Robot entity
 *
 * @author Smirnoff Y
 * @see Object
 * @since 9/22/12 11:35 PM
 */
public class Robot extends Object {

    private RobotType type;
    private int visibilityRadius;
    private double visibilityAngle;
    private Map<String, Double> parameters;

    public Robot(Color color, int size, double orientation, Intersection intersection, RobotType type,
                 int visibilityRadius, double visibilityAngle, Point coordinates, Map<String, Double> parameters) {
        super(color, size, orientation, intersection, coordinates);
        this.type = type;
        this.visibilityRadius = visibilityRadius;
        this.visibilityAngle = visibilityAngle;
        this.parameters = parameters;
    }

    public Double getParameter(String parameter) {
        return parameters.get(parameter);
    }

    public RobotType getType() {
        return type;
    }

    public int getVisibilityRadius() {
        return visibilityRadius;
    }

    public double getVisibilityAngle() {
        return visibilityAngle;
    }
}
