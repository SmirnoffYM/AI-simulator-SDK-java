package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;

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

    public BumpMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        return ByteBuffer.allocate(header.length + dataSize).put(header).putInt(x).putInt(y);
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
