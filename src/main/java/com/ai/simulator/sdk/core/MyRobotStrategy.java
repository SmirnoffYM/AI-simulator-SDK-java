package com.ai.simulator.sdk.core;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.messages.impl.ThereYouSeeMessage;
import java.util.List;
import java.util.Random;

/**
 * Strategy needed 4 testing purposes
 *
 * @author Smirnoff Y
 * @since 11/18/12 9:54 PM
 */
@SuppressWarnings("unused")
public class MyRobotStrategy implements RobotStrategy {

    private boolean moved = false;
    int currentX = 12000;
    int currentY = 12000;
    int destX = 12000;
    int destY = 12000;

    int maxX = 20000;
    int minX = 2000;
    int maxY = 20000;
    int minY = 2000;
    int stX = 0;
    int stY = 0;

    boolean first = true;

    int stepSize = 200;

    Random r = new Random(System.nanoTime());

    @Override
    public void action() {

        if (currentX >= maxX || currentY >= maxY || currentX <= minX || currentY <= minY || first) {
            first = false;
            destX = r.nextInt(maxX - minX) + minX;
            destY = r.nextInt(maxY - minY) + minY;
            HubModule.getActions().changeSize(r.nextInt(1000) + 400);
            stX = (destX - currentX) / stepSize;
            stY = (destY - currentY) / stepSize;
        }

        currentX += stX;
        currentY += stY;

        HubModule.getActions().move(currentX, currentY);
    }

    @Override
    public void onBumpReceived(int x, int y) {

    }

    @Override
    public void onMovedSuccessfullyReceived() {
        moved = true;
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
