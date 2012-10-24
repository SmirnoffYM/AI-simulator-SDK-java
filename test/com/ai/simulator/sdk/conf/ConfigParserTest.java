package com.ai.simulator.sdk.conf;

import com.ai.simulator.sdk.agent.Robot;
import com.ai.simulator.sdk.world.Intersection;
import com.ai.simulator.sdk.world.Point;
import com.ai.simulator.sdk.world.RobotType;
import junit.framework.Assert;
import org.junit.Test;

/**
 * Test for ConfigParser class
 *
 * @author Smirnoff Y
 * @see ConfigParser
 * @since 10/6/12 10:48 PM
 */
public class ConfigParserTest {

    @Test
    public void parseRobotTest() throws Exception {
        Robot robot = ConfigParser.parse("8085.1.ini");
        Assert.assertEquals(new Point(12000, 12000), robot.getCoordinates());
        Assert.assertEquals(600, robot.getSize());
        Assert.assertEquals(RobotType.Normal, robot.getType());
        Assert.assertEquals(3000, robot.getVisibilityRadius());
        Assert.assertEquals(90.0, robot.getVisibilityAngle());
        Assert.assertEquals(Intersection.Allowed, robot.getIntersection());
        Assert.assertEquals(315.0, robot.getOrientation());
        Assert.assertEquals(0, robot.getColor().red().intValue());
        Assert.assertEquals(0, robot.getColor().green().intValue());
        Assert.assertEquals(255, robot.getColor().blue().intValue());
        Assert.assertEquals("#0000ff", robot.getColor().toString());
        Assert.assertEquals(8.0, robot.getParameter("Hh"));
        Assert.assertNull(robot.getParameter("fail"));
    }

    //TODO: test for parsing environment
}
