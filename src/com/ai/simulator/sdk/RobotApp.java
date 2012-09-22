package com.ai.simulator.sdk;

import java.io.File;

/**
 * Main class for the robot application
 *
 * @author Smirnoff Y
 * @since 9/22/12 11:17 PM
 */
public class RobotApp {

    public static void main(String[] args) throws AppException {
        if (args == null || args.length != 1)
            throw new AppException("Invalid application parameter");
        File config = new File(args[0]);
        if (!config.exists() || !config.isFile() || !config.canRead())
            throw new AppException("Configuration file doesn't exist or cannot be read");
        //TODO: read config
        //TODO: launch robot
    }
}
