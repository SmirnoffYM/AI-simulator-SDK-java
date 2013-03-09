package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.messages.EmptyMessage;
import com.ai.simulator.sdk.messages.SimulatorMessage;
import com.ai.simulator.sdk.util.Constants;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Hit! message class (type = 6)
 *
 * @author Smirnoff Y
 * @see EmptyMessage
 * @see SimulatorMessage
 * @since 10/17/12 11:01 AM
 */
@SimulatorMessage(type = 6)
public final class HitMessage extends EmptyMessage {

    public HitMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    public DatagramPacket pack() {
//        ByteBuffer buffer = ByteBuffer.allocate(headerBytes).
//                put(protocolVersion.byteValue()).putInt(10).put(envObjectID.byteValue()).
//                putShort(port.shortValue()).put(type.byteValue());
//        byte[] buf = buffer.array();
//        return new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), Constants.SIMULATOR_PORT);
        // TODO: implement
        return null;
    }
}
