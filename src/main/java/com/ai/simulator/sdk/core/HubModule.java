package com.ai.simulator.sdk.core;

import com.ai.simulator.sdk.AppException;
import com.ai.simulator.sdk.agent.Robot;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.impl.*;
import com.ai.simulator.sdk.util.ModellingState;

import java.net.SocketException;

/**
 * TODO: description
 *
 * @author Smirnoff Y
 * @since 11/6/12 9:29 PM
 */
public class HubModule {

    private static volatile ModellingState modellingState = ModellingState.Started;
    private final NetworkManager networkManager;
    private volatile Robot robot;
    private static RobotActions actions = null;
    private RobotStrategy robotStrategy;
    private final int port;

    public HubModule(Robot robot, int port, RobotStrategy robotStrategy) throws SocketException, AppException {
        if (actions != null)
            throw new AppException("Do not try to leave Omsk!"); //TODO: shitty code, yeah? It must be refactored.
        this.robot = robot;
        this.port = port;
        networkManager = new NetworkManager(port);
        actions = new RobotActions(this);
        this.robotStrategy = robotStrategy;
    }

    //TODO: do we need this function?
    public void start() {
        startReceivingMessages();
        networkManager.start();
    }

    public static ModellingState getModellingState() {
        return modellingState;
    }

    public Robot getRobot() {
        return robot;
    }

    public void send(Message message) {
        networkManager.send(message);
    }

    public static RobotActions getActions() {
        return actions;
    }

    public int getPort() {
        return port;
    }

    private void startReceivingMessages() {
        Thread messageReceiver = new Thread() {
            @Override
            public void run() {
                //TODO: use frequency?
                while (modellingState != ModellingState.Stopped) {
                    Message message = networkManager.getReceived();
                    if (message != null) {
                        // check for pause message
                        if (message.getClass().equals(PauseMessage.class))
                            modellingState = ModellingState.Paused;
                        // check for start message
                        else if (message.getClass().equals(StartMessage.class))
                            modellingState = ModellingState.Started;
                        // check for bump message
                        else if (message.getClass().equals(BumpMessage.class)) {
                            BumpMessage bumpMessage = (BumpMessage) message;
                            robotStrategy.onBumpReceived(bumpMessage.getX(), bumpMessage.getY());
                        }
                        // check for moved successfully message
                        else if (message.getClass().equals(MovedSuccessfullyMessage.class))
                            robotStrategy.onMovedSuccessfullyReceived();
                        // check for "there you see" reply
                        else if (message.getClass().equals(ThereYouSeeMessage.class)) {
                            ThereYouSeeMessage thereYouSeeMessage = (ThereYouSeeMessage) message;
                            robotStrategy.onThereYouSeeReceived(((ThereYouSeeMessage) message).getObjects());
                        }
                        // check for navigation chart messages
                        else if (message.getClass().equals(NavigationChartMessage.class)) {
                            NavigationChartMessage chartMessage = (NavigationChartMessage) message;
                            robotStrategy.onNavigationChartReceived(chartMessage.getX(), chartMessage.getY(),
                                    chartMessage.getWidth(), chartMessage.getHeight(), chartMessage.getPointHeights());
                        }
                        // check for being hit message
                        else if (message.getClass().equals(HitMessage.class))
                            robotStrategy.onHitReceived();

                    }
                }
            }
        };
        messageReceiver.start();
    }
}
