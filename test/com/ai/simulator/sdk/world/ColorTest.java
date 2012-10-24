package com.ai.simulator.sdk.world;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Test 4 Color class
 *
 * @author Smirnoff Y
 * @see Color
 * @since 10/17/12 9:00 AM
 */
public class ColorTest {

    @Test
    public void stringConstructorTest() {
        Color color = new Color("#0000ff");
        Assert.assertEquals(0, color.red().intValue());
        Assert.assertEquals(0, color.green().intValue());
        Assert.assertEquals(255, color.blue().intValue());
        Assert.assertEquals("#0000ff", color.toString());
        color = new Color("#123456");
        Assert.assertEquals(18, color.red().intValue());
        Assert.assertEquals(52, color.green().intValue());
        Assert.assertEquals(86, color.blue().intValue());
        Assert.assertEquals("#123456", color.toString());
    }

    @Test
    public void integersConstructorTest() {
        Color color = new Color(0, 0, 255);
        Assert.assertEquals(0, color.red().intValue());
        Assert.assertEquals(0, color.green().intValue());
        Assert.assertEquals(255, color.blue().intValue());
        Assert.assertEquals("#0000ff", color.toString());
        color = new Color(18, 52, 86);
        Assert.assertEquals(18, color.red().intValue());
        Assert.assertEquals(52, color.green().intValue());
        Assert.assertEquals(86, color.blue().intValue());
        Assert.assertEquals("#123456", color.toString());
        color = new Color("#64c832");
        Assert.assertEquals(100, color.red().intValue());
        Assert.assertEquals(200, color.green().intValue());
        Assert.assertEquals(50, color.blue().intValue());
        Assert.assertEquals(new Color(100, 200, 50), color);
    }

    @Test
    public void equalsTest() {
        Assert.assertTrue(new Color(0, 0, 255).equals(new Color("#0000ff")));
        Assert.assertTrue(new Color(18, 52, 86).equals(new Color("#123456")));
    }
}
