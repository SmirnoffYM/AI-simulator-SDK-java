package com.ai.simulator.sdk.conf;

import com.ai.simulator.sdk.AppException;
import com.ai.simulator.sdk.agent.Robot;
import com.ai.simulator.sdk.world.Color;
import com.ai.simulator.sdk.world.Intersection;
import com.ai.simulator.sdk.world.Point;
import com.ai.simulator.sdk.world.RobotType;
import org.ini4j.Ini;
import org.ini4j.Profile;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

/**
 * Utility class that parses robot and environment profiles
 *
 * @author Smirnoff Y
 * @see Ini
 * @since 10/6/12 10:08 PM
 */
public class ConfigParser {

    protected ConfigParser() {
    }

    public static Robot parse(String fileName) throws IOException, AppException {
        Reader reader = new FileReader(fileName);
        Ini ini = new Ini();
        ini.load(reader);
        Profile.Section robotSection = ini.get("robot");
        Color color = new Color(robotSection.get("color"));
        int size = Integer.parseInt(robotSection.get("size"));
        double orientation = Double.parseDouble(robotSection.get("orientation"));
        Intersection intersection = Intersection.fromInt(Integer.parseInt(robotSection.get("intersection")));
        RobotType robotType = RobotType.fromInt(Integer.parseInt(robotSection.get("type")));
        int visibilityRadius = Integer.parseInt(robotSection.get("visibilityRadius"));
        double visibilityAngle = Double.parseDouble(robotSection.get("visibilityAngle"));
        Point coordinates = new Point(Integer.parseInt(robotSection.get("startX")),
                Integer.parseInt(robotSection.get("startY")));
        Map<String, Double> customParams = new HashMap<String, Double>();
        Profile.Section customParamsSection = ini.get("robot_custom_params");
        for (String param : customParamsSection.keySet())
            customParams.put(param, Double.valueOf(customParamsSection.get(param)));
        if (orientation < 0 || visibilityAngle < 0 || orientation > 360 || visibilityAngle > 360 ||
                size <= 0 || visibilityRadius < 0 || coordinates.x() < 0 || coordinates.y() < 0)
            throw new AppException("Invalid robot profile format. Look at AI-simulator wiki");
        reader.close();
        return new Robot(color, size, orientation, intersection, robotType, visibilityRadius, visibilityAngle,
                coordinates, customParams);
    }

    //TODO: parser for environment profile
}
