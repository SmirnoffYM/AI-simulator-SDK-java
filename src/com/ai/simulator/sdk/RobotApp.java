package com.ai.simulator.sdk;

import com.ai.simulator.sdk.conf.ConfigParser;
import com.ai.simulator.sdk.agent.Robot;

import java.io.IOException;

/**
 * Main class for the object application
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:17 PM
 */
public class RobotApp {

    public static void main(String[] args) throws AppException, IOException {
        if (args == null || args.length != 1)
            throw new AppException("Invalid application parameter");
        Robot robot = ConfigParser.parse(args[0]);
        //TODO: launch object
    }
}
