package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;

import java.nio.ByteBuffer;

/**
 * Who is there? message class (type = 4)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 10:48 AM
 */
@SimulatorMessage(type = 4)
public final class WhoIsThereMessage extends Message {

    private static final int dataSize = 4;

    private UnsignedInt distance;

    public WhoIsThereMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        return ByteBuffer.allocate(header.length + dataSize).put(header).putInt(distance.intValue());
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        distance = new UnsignedInt(buffer.getInt());
    }

    public UnsignedInt getDistance() {
        return distance;
    }

    public void setDistance(UnsignedInt distance) {
        this.distance = distance;
    }
}
