package com.ai.simulator.sdk.compatibility;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Test 4 UnsignedByte, UnsignedShort and UnsignedInt classes
 *
 * @author Smirnoff Y
 * @see UnsignedByte
 * @see UnsignedShort
 * @see UnsignedInt
 * @since 10/23/12 8:19 PM
 */
public class UnsignedTypesTest {

    @Test
    public void byteTest() {
        UnsignedByte value = new UnsignedByte(200);
        Assert.assertEquals(new Byte("-56"), (Byte) value.byteValue());
        Assert.assertEquals(200, value.intValue());
        Assert.assertEquals("200", value.toString());
        value = new UnsignedByte(100);
        Assert.assertEquals(new Byte("100"), (Byte) value.byteValue());
        Assert.assertEquals(100, value.intValue());
        Assert.assertEquals("100", value.toString());
        try{
            new UnsignedByte(100500);
            Assert.fail();
        } catch (TypeCastException e) {
            // exception is expected
        }
        value = new UnsignedByte(new Byte("-56"));
        Assert.assertEquals(200, value.intValue());
        value = new UnsignedByte(new Byte("100"));
        Assert.assertEquals(100, value.intValue());
    }

    @Test
    public void shortTest() {
        UnsignedShort value = new UnsignedShort(32768);
        Assert.assertEquals(new Short("-32768"), (Short) value.shortValue());
        Assert.assertEquals(32768, value.intValue());
        Assert.assertEquals("32768", value.toString());
        value = new UnsignedShort(100);
        Assert.assertEquals(new Short("100"), (Short) value.shortValue());
        Assert.assertEquals(100, value.intValue());
        Assert.assertEquals("100", value.toString());
        try{
            new UnsignedShort(100500);
            Assert.fail();
        } catch (TypeCastException e) {
            // exception is expected
        }
        value = new UnsignedShort(new Short("-32768"));
        Assert.assertEquals(32768, value.intValue());
        value = new UnsignedShort(new Short("100"));
        Assert.assertEquals(100, value.intValue());
    }

    @Test
    public void intTest() {
        UnsignedInt value = new UnsignedInt(2147483648l);
        Assert.assertEquals(-2147483648, value.intValue());
        Assert.assertEquals(2147483648l, value.longValue());
        Assert.assertEquals("2147483648", value.toString());
        value = new UnsignedInt(100);
        Assert.assertEquals(100, value.intValue());
        Assert.assertEquals(100l, value.longValue());
        Assert.assertEquals("100", value.toString());
        try{
            new UnsignedInt(21474836123448l);
            Assert.fail();
        } catch (TypeCastException e) {
            // exception is expected
        }
        value = new UnsignedInt(new Integer("-2147483648"));
        Assert.assertEquals(2147483648l, value.longValue());
        value = new UnsignedInt(new Integer("100"));
        Assert.assertEquals(100, value.longValue());
    }
}
