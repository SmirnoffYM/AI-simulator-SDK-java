package com.ai.simulator.sdk.core;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.messages.impl.ThereYouSeeMessage;

import java.util.List;

/**
 * TODO: description
 *
 * @author Smirnoff Y
 * @since 11/18/12 12:56 AM
 */
public interface RobotStrategy {

    public void action();

    public void onBumpReceived(int x, int y, boolean isMapBoundary);

    public void onMovedSuccessfullyReceived();

    public void onThereYouSeeReceived(List<ThereYouSeeMessage.Object> objects);

    public void onNavigationChartReceived(int x, int y, UnsignedByte width, UnsignedByte height,
                                          UnsignedByte[][] pointsHeight);
    public void onHitReceived();

}
