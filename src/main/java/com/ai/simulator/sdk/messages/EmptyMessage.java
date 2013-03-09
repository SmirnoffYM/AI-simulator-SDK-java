package com.ai.simulator.sdk.messages;

import java.net.DatagramPacket;
import java.nio.ByteBuffer;

/**
 * Abstract class for messages containing only header
 *
 * @author Smirnoff Y
 * @see Message
 * @since 10/18/12 11:34 AM
 */
public abstract class EmptyMessage extends Message {

    protected EmptyMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    public DatagramPacket pack() {
        // TODO: implement
        return null;
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        // Do nothing
    }
}
