package com.ai.simulator.sdk.core;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.messages.impl.*;
import com.ai.simulator.sdk.util.Constants;
import com.ai.simulator.sdk.world.Color;

import java.util.Random;

/**
 * TODO: description
 *
 * @author Smirnoff Y
 * @since 11/18/12 9:27 PM
 */
@SuppressWarnings("unused")
public class RobotActions {

    private final HubModule hub;
    private Random random = new Random();

    public RobotActions(HubModule hub) {
        this.hub = hub;
    }

    public void move(int relativeX, int relativeY) {
        MoveMessage message = new MoveMessage(random.nextInt(), 0, Constants.SIMULATOR_PORT);
        message.setX(relativeX);
        message.setY(relativeY);
        hub.send(message);
    }

    public void turn(int relativeOrientation) {
        TurnMessage message = new TurnMessage(random.nextInt(), 0, Constants.SIMULATOR_PORT);
        message.setDegrees(new UnsignedInt(relativeOrientation));
        hub.send(message);
    }

    public void changeSize(int newSize) {
        ChangeSizeMessage message = new ChangeSizeMessage(random.nextInt(), 0, Constants.SIMULATOR_PORT);
        message.setDiameter(new UnsignedInt(newSize));
        hub.send(message);
    }

    public void changeColor(Color newColor) {
        ChangeColorMessage message = new ChangeColorMessage(random.nextInt(), 0, Constants.SIMULATOR_PORT);
        message.setColor(newColor);
        hub.send(message);
    }

    public void whoIsThere(UnsignedInt distance) {
        WhoIsThereMessage message = new WhoIsThereMessage(random.nextInt(), 0, Constants.SIMULATOR_PORT);
        message.setDistance(distance);
        hub.send(message);
    }

    public void parameterReport(Integer integralPart, UnsignedInt realPart, UnsignedByte parameterId) {
        ParameterReportMessage message = new ParameterReportMessage(random.nextInt(), 0, Constants.SIMULATOR_PORT);
        message.setIntegralPart(integralPart);
        message.setParameterId(parameterId);
        message.setRealPart(realPart);
        hub.send(message);
    }
}
