package com.ai.simulator.sdk;

import com.ai.simulator.sdk.conf.ConfigParser;
import com.ai.simulator.sdk.agent.Robot;
import com.ai.simulator.sdk.core.HubModule;
import com.ai.simulator.sdk.core.MyRobotStrategy;
import com.ai.simulator.sdk.core.RobotStrategy;
import com.ai.simulator.sdk.util.ModellingState;

import java.io.IOException;

/**
 * Main class for the object application
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:17 PM
 */
public class RobotApp {

    public static class RobotRunner implements Runnable {
        private HubModule hubModule;
        private RobotStrategy robotStrategy;

        public RobotRunner(Robot robot, int port) throws Exception {
            robotStrategy = new MyRobotStrategy();
            hubModule = new HubModule(robot, port, robotStrategy);
            hubModule.start();
        }

        public void run() {
            while(true) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }
                if (HubModule.getModellingState() == ModellingState.Started) {
                    robotStrategy.action();
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 1)
            throw new AppException("Invalid application parameter");
        Robot robot = ConfigParser.parse(args[0] + ".ini");
        int port = Integer.parseInt(args[0].substring(0, args[0].indexOf(".")));

        Thread robotRunner = new Thread (new RobotRunner(robot, port));
        robotRunner.start();
    }
}
