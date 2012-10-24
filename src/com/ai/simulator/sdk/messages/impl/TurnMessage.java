package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;

import java.nio.ByteBuffer;

/**
 * Turn message class (type = 1)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 10:32 AM
 */
@SimulatorMessage(type = 1)
public final class TurnMessage extends Message {

    private static final int dataSize = 4;

    private UnsignedInt degrees;

    public TurnMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        return ByteBuffer.allocate(header.length + dataSize).put(header).putInt(degrees.intValue());
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        degrees = new UnsignedInt(buffer.getInt());
    }

    public UnsignedInt getDegrees() {
        return degrees;
    }

    public void setDegrees(UnsignedInt degrees) {
        this.degrees = degrees;
    }
}
