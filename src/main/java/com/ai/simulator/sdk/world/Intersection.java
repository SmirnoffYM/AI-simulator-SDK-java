package com.ai.simulator.sdk.world;

import com.ai.simulator.sdk.AppException;

/**
 * Available intersection types
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:32 PM
 */
public enum Intersection {

    Allowed, Denied, AllowedForSameColor;

    public static Intersection fromInt(int intersection) throws AppException {
        switch (intersection) {
            case 0:
                return Intersection.Allowed;
            case 1:
                return Intersection.Denied;
            case 2:
                return Intersection.AllowedForSameColor;
            default:
                throw new AppException("Invalid intersection param value");
        }
    }
}
