package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;
import com.ai.simulator.sdk.util.Constants;
import com.ai.simulator.sdk.world.Color;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Change color message class (type = 3)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 10:43 AM
 */
@SimulatorMessage(type = 3)
public final class ChangeColorMessage extends Message {

    private static final int dataSize = 3;

    private Color color;

    public ChangeColorMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    public DatagramPacket pack() throws UnknownHostException {
        ByteBuffer buffer = ByteBuffer.allocate(headerBytes + dataSize).
                put(protocolVersion.byteValue()).putInt(10).put(envObjectID.byteValue()).
                putShort(port.shortValue()).put(type.byteValue()).put(color.green().
                byteValue()).put(color.blue().byteValue());
        byte[] buf = buffer.array();
        return new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), Constants.SIMULATOR_PORT);
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        color = new Color(buffer.get(), buffer.get(), buffer.get());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
