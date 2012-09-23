package com.ai.simulator.sdk.world;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Unit test for {@link com.ai.simulator.sdk.world.Color} class
 *
 * @author Smirnoff Y
 * @since 9/23/12 12:57 PM
 */
public class ColorTest {

    @Test
    public void test() {
        Color color = new Color(255, 255, 255);
        Assert.assertEquals("#ffffff", color.toString());
        color = new Color("#2a3b4c");
        Assert.assertEquals(42, color.red());
        Assert.assertEquals(59, color.green());
        Assert.assertEquals(76, color.blue());
        try{
            new Color("#AABBC");
            Assert.fail();
        } catch (Exception e) {/* ignore */}
    }
}
