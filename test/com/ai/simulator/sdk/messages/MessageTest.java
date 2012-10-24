package com.ai.simulator.sdk.messages;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.compatibility.UnsignedShort;
import com.ai.simulator.sdk.messages.impl.*;
import com.ai.simulator.sdk.world.Color;
import junit.framework.Assert;
import org.junit.Test;
import java.net.DatagramPacket;
import java.util.Arrays;

/**
 * Test for message classes
 *
 * @author Smirnoff Y
 * @see Message
 * @see MoveMessage
 * @since 10/16/12 12:27 PM
 */
public class MessageTest {

    @Test
    public void moveMessageTest() throws Exception {
        MoveMessage message = new MoveMessage((int) 4294967295l, 0, 65535);
        message.setX(5);
        message.setY(6);
        MoveMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(5, unpackedMessage.getX());
        Assert.assertEquals(6, unpackedMessage.getY());
    }

    @Test
    public void startMessageTest() throws Exception {
        StartMessage message = new StartMessage((int) 4294967295l, 0, 65535);
        packUnpackAndTest(message);
    }

    @Test
    public void turnMessageTest() throws Exception {
        TurnMessage message = new TurnMessage((int) 4294967295l, 0, 65535);
        message.setDegrees(new UnsignedInt(4294967295l));
        TurnMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(4294967295l, unpackedMessage.getDegrees().longValue());
    }

    @Test
    public void bumpMessageTest() throws Exception {
        BumpMessage message = new BumpMessage((int) 4294967295l, 0, 65535);
        message.setX(5);
        message.setY(6);
        BumpMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(5, unpackedMessage.getX());
        Assert.assertEquals(6, unpackedMessage.getY());
    }

    @Test
    public void changeColorMessageTest() throws Exception {
        Color color = new Color(100, 200, 50);
        ChangeColorMessage message = new ChangeColorMessage((int) 4294967295l, 0, 65535);
        message.setColor(color);
        ChangeColorMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(color, unpackedMessage.getColor());
    }

    @Test
    public void changeSizeMessageTest() throws Exception {
        ChangeSizeMessage message = new ChangeSizeMessage((int) 4294967295l, 0, 65535);
        message.setDiameter(new UnsignedInt(4294967295l));
        ChangeSizeMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(4294967295l, unpackedMessage.getDiameter().longValue());
    }

    @Test
    public void hitMessageTest() throws Exception {
        HitMessage message = new HitMessage((int) 4294967295l, 0, 65535);
        packUnpackAndTest(message);
    }

    @Test
    public void movedSuccessfullyMessageTest() throws Exception {
        MovedSuccessfullyMessage message = new MovedSuccessfullyMessage((int) 4294967295l, 0, 65535);
        packUnpackAndTest(message);
    }

    @Test
    public void navigationChartMessageTest() throws Exception {
        NavigationChartMessage message = new NavigationChartMessage((int) 4294967295l, 0, 65535);
        message.setFragmentId(new UnsignedShort(65535));
        message.setX(14);
        message.setY(88);
        message.setWidth(new UnsignedByte(1));
        message.setHeight(new UnsignedByte(2));
        message.setPointHeights(new UnsignedByte[][] {{new UnsignedByte(200), new UnsignedByte(127)}});
        NavigationChartMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(65535, unpackedMessage.getFragmentId().intValue());
        Assert.assertEquals(14, unpackedMessage.getX());
        Assert.assertEquals(88, unpackedMessage.getY());
        Assert.assertEquals(1, unpackedMessage.getWidth().intValue());
        Assert.assertEquals(2, unpackedMessage.getHeight().intValue());
        Assert.assertEquals(200, unpackedMessage.getPointHeights()[0][0].intValue());
        Assert.assertEquals(127, unpackedMessage.getPointHeights()[0][1].byteValue());
    }

    @Test
    public void parameterReportMessageTest() throws Exception {
        ParameterReportMessage message = new ParameterReportMessage((int) 4294967295l, 0, 65535);
        message.setIntegralPart(-2);
        message.setRealPart(new UnsignedInt(5));
        message.setParameterId(new UnsignedByte(200));
        ParameterReportMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(-2, unpackedMessage.getIntegralPart().intValue());
        Assert.assertEquals(5, unpackedMessage.getRealPart().intValue());
        Assert.assertEquals(-56, unpackedMessage.getParameterId().byteValue());
    }

    @Test
    public void pauseMessageTest() throws Exception {
        PauseMessage message = new PauseMessage((int) 4294967295l, 0, 65535);
        packUnpackAndTest(message);
    }

    @Test
    public void thereYouSeeMessageTest() throws Exception {
        Color color = new Color(100, 200, 50);
        ThereYouSeeMessage message = new ThereYouSeeMessage((int) 4294967295l, 0, 65535);
        message.setMapPiecesNumber(new UnsignedShort(100));
        message.setObjects(Arrays.asList(new ThereYouSeeMessage.Object(0, 2, 3),
                new ThereYouSeeMessage.AgentObject(4, 5, 6, (short) 7, color)));
        ThereYouSeeMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(100, unpackedMessage.getMapPiecesNumber().shortValue());
        Assert.assertEquals(2, unpackedMessage.getObjects().size());
        ThereYouSeeMessage.Object object = unpackedMessage.getObjects().get(0);
        ThereYouSeeMessage.AgentObject agentObject =
                (ThereYouSeeMessage.AgentObject) unpackedMessage.getObjects().get(1);
        Assert.assertEquals(0, object.getType().byteValue());
        Assert.assertEquals(2, object.getX());
        Assert.assertEquals(3, object.getY());
        Assert.assertEquals(4, agentObject.getX());
        Assert.assertEquals(5, agentObject.getY());
        Assert.assertEquals(6, agentObject.getDiameter().intValue());
        Assert.assertEquals(7, agentObject.getOrientation().shortValue());
        Assert.assertEquals(color, agentObject.getColor());
    }

    @Test
    public void whoIsThereMessageTest() throws Exception {
        WhoIsThereMessage message = new WhoIsThereMessage((int) 4294967295l, 0, 65535);
        message.setDistance(new UnsignedInt(4294967295l));
        WhoIsThereMessage unpackedMessage = packUnpackAndTest(message);
        Assert.assertEquals(4294967295l, unpackedMessage.getDistance().longValue());
    }

    protected <T extends Message> T packUnpackAndTest(T message) throws Exception {
        DatagramPacket packet = message.pack();
        T unpackedMessage = Message.unpack(packet);
        Assert.assertEquals(0, unpackedMessage.getEnvObjectID().intValue());
        Assert.assertEquals(4294967295l, unpackedMessage.getSequentialNumber().longValue());
        Assert.assertEquals(65535, unpackedMessage.getPort().intValue());
        Assert.assertEquals(3, unpackedMessage.getProtocolVersion().intValue());
        return unpackedMessage;
    }
}
