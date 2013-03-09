package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;
import com.ai.simulator.sdk.util.Constants;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.UnknownHostException;
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
    public DatagramPacket pack() throws UnknownHostException {
        ByteBuffer buffer = ByteBuffer.allocate(headerBytes + dataSize).
                put(protocolVersion.byteValue()).putInt(10).put(envObjectID.byteValue()).
                putShort(port.shortValue()).put(type.byteValue()).putInt(degrees.intValue());
        byte[] buf = buffer.array();
        return new DatagramPacket(buf, buf.length, InetAddress.getByName("localhost"), Constants.SIMULATOR_PORT);
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
