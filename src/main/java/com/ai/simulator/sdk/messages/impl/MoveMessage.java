package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;
import com.ai.simulator.sdk.util.Constants;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * Move message class (type=0)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 9/23/12 8:14 PM
 */
@SimulatorMessage(type = 0)
public final class MoveMessage extends Message {

    private static final int dataSize = 8;

    private int x;
    private int y;

    public MoveMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    public DatagramPacket pack() throws UnknownHostException {
        ByteBuffer buffer = ByteBuffer.allocate(headerBytes + dataSize).
                put(protocolVersion.byteValue()).putInt(sequentialNumber.intValue()).put(envObjectID.byteValue()).
                putShort(port.shortValue()).put(type.byteValue()).putInt(x).putInt(y);
        byte[] buf = buffer.array();
        return new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), Constants.SIMULATOR_PORT);
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        x = buffer.getInt();
        y = buffer.getInt();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
