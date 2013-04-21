package com.ai.simulator.sdk.messages;

import com.ai.simulator.sdk.AppException;
import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.compatibility.UnsignedShort;
import com.ai.simulator.sdk.util.Constants;

import java.lang.reflect.InvocationTargetException;
import java.net.DatagramPacket;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;

/**
 * Abstract message class, which contains only a header. All AI-simulator messages must extend it.
 *
 * @author Smirnoff Y
 * @see UnsignedByte
 * @see UnsignedShort
 * @see UnsignedInt
 * @see MessagesContainer
 * @see SimulatorMessage
 * @since 9/23/12 5:07 PM
 */
public abstract class Message {

    protected static final int headerBytes = 10;

    protected UnsignedByte protocolVersion;
    protected UnsignedInt sequentialNumber;
    protected UnsignedShort envObjectID;
    protected UnsignedShort port;
    protected UnsignedByte type;

    protected Message(int sequentialNumber, int envObjectID, int port) {
        protocolVersion = new UnsignedByte(Constants.PROTOCOL_VERSION);
        this.sequentialNumber = new UnsignedInt(sequentialNumber);
        this.envObjectID = new UnsignedShort(envObjectID);
        this.port = new UnsignedShort(port);
        this.type = new UnsignedByte(getClass().getAnnotation(SimulatorMessage.class).type());
    }

    public static <T extends Message> T unpack(DatagramPacket packet) throws AppException, NoSuchMethodException,
            InvocationTargetException, IllegalAccessException, InstantiationException {
        ByteBuffer buffer = ByteBuffer.wrap(packet.getData());

        byte protocolVersion = buffer.get();
        if (protocolVersion != Constants.PROTOCOL_VERSION)
            throw new AppException("Application received message with invalid protocol number = " + protocolVersion);
        int sequentialNumber = buffer.getInt();

        UnsignedByte envObjectID = new UnsignedByte(buffer.get());
        UnsignedShort port = new UnsignedShort(buffer.getShort());
        UnsignedByte type = new UnsignedByte(buffer.get());

        Class<T> messageClass = MessagesContainer.getMessage(type.intValue());
        T message = messageClass.getConstructor(int.class, int.class, int.class).
                newInstance(sequentialNumber, envObjectID.intValue(), port.intValue());
        message.unpack(buffer);
        return message;
    }


    public abstract DatagramPacket pack() throws UnknownHostException;

    protected abstract void unpack(ByteBuffer buffer);

    public UnsignedByte getProtocolVersion() {
        return protocolVersion;
    }

    public UnsignedInt getSequentialNumber() {
        return sequentialNumber;
    }

    public UnsignedShort getEnvObjectID() {
        return envObjectID;
    }

    public UnsignedShort getPort() {
        return port;
    }
}
