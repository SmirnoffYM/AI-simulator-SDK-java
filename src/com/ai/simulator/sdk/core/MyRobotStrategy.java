package com.ai.simulator.sdk.core;

import com.ai.simulator.sdk.agent.EnvironmentMap;
import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.messages.impl.ThereYouSeeMessage;

import java.util.List;

/**
 * TODO: description
 *
 * @author Smirnoff Y
 * @since 11/18/12 9:54 PM
 */
public class MyRobotStrategy implements RobotStrategy {

    @Override
    public void action() {

    }

    @Override
    public void onBumpReceived(int x, int y) {

    }

    @Override
    public void onMovedSuccessfullyReceived() {

    }

    @Override
    public void onThereYouSeeReceived(List<ThereYouSeeMessage.Object> objects) {

    }

    @Override
    public void onNavigationChartReceived(int x, int y, UnsignedByte width, UnsignedByte height,
                                          UnsignedByte[][] pointsHeight) {

    }

    @Override
    public void onHitReceived() {

    }
}
