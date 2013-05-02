package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;
import com.ai.simulator.sdk.util.Constants;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Bump! message class (type = 5)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 10:58 AM
 */
@SimulatorMessage(type = 5)
public final class BumpMessage extends Message {

    private static final int dataSize = 8;

    private int x;
    private int y;
    private byte bumpType;

    public BumpMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    public DatagramPacket pack() throws UnknownHostException {
        ByteBuffer buffer = ByteBuffer.allocate(headerBytes + dataSize).
                put(protocolVersion.byteValue()).putInt(10).put(envObjectID.byteValue()).
                putShort(port.shortValue()).put(type.byteValue()).putInt(x).putInt(y).put(bumpType);
        byte[] buf = buffer.array();
        return new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), Constants.SIMULATOR_PORT);
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        x = buffer.getInt();
        y = buffer.getInt();
        bumpType = buffer.get();
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

    public byte getBumpType() {
        return bumpType;
    }

    public void setBumpType(byte bumpType) {
        this.bumpType = bumpType;
    }
}
