package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;

import java.nio.ByteBuffer;

/**
 * Change size message class (type = 2)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 10:39 AM
 */
@SimulatorMessage(type = 2)
public final class ChangeSizeMessage extends Message {

    private static final int dataSize = 4;

    private UnsignedInt diameter;

    public ChangeSizeMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        return ByteBuffer.allocate(header.length + dataSize).put(header).putInt(diameter.intValue());
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        diameter = new UnsignedInt(buffer.getInt());
    }

    public UnsignedInt getDiameter() {
        return diameter;
    }

    public void setDiameter(UnsignedInt diameter) {
        this.diameter = diameter;
    }
}
