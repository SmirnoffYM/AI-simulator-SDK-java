package com.ai.simulator.sdk.world;

import com.ai.simulator.sdk.AppException;

/**
 * Available types of the object
 *
 * @author Smirnoff Y
 * @since 10/6/12 10:03 PM
 */
public enum RobotType {

    Normal, Flying;

    public static RobotType fromInt(int robotType) throws AppException {
        switch (robotType) {
            case 0:
                return RobotType.Normal;
            case 1:
                return RobotType.Flying;
            default:
                throw new AppException("Invalid robot type param value");
        }
    }
}
