package com.ai.simulator.sdk;

import com.ai.simulator.sdk.conf.ConfigParser;
import com.ai.simulator.sdk.agent.Robot;
import com.ai.simulator.sdk.core.HubModule;
import com.ai.simulator.sdk.core.RobotStrategy;
import com.ai.simulator.sdk.util.ModellingState;

/**
 * Main class for the object application
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:17 PM
 */
public class RobotApp {

    public static class RobotRunner implements Runnable {
        private HubModule hubModule;
        private RobotStrategy strategy;

        public RobotRunner(Robot robot, RobotStrategy strategy, int port) throws Exception {
            this.strategy = strategy;
            hubModule = new HubModule(robot, port, strategy);
            hubModule.start();
        }

        public void run() {
            while(true) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (HubModule.getModellingState() == ModellingState.Started) {
                    strategy.action();
                }
            }
        }
    }

    /**
     * Main function
     *
     * @param args first arg = robot strategy class, second = config filename without ext like 8085.1
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        if (args == null || args.length != 2)
            throw new AppException("Invalid config parameter");
        Robot robot;
        try {
            robot = ConfigParser.parse(args[1] + ".ini");
        }
        catch (Exception e) {
            robot = ConfigParser.parse("robots/" + args[1] + ".ini");
        }
        int port = Integer.parseInt(args[1].substring(0, args[1].indexOf(".")));
        Class strategyClass = Class.forName(args[0]);
        if (!RobotStrategy.class.isAssignableFrom(strategyClass))
            throw new AppException("Invalid robot strategy class");

        Thread robotRunner = new Thread (new RobotRunner(robot, (RobotStrategy) strategyClass.newInstance(), port));
        robotRunner.start();
    }
}
