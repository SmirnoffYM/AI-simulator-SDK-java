package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;

import java.nio.ByteBuffer;

/**
 * Parameter report message class (type = 10)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 10:51 AM
 */
@SimulatorMessage(type = 10)
public final class ParameterReportMessage extends Message {

    private static final int dataSize = 9;

    private UnsignedByte parameterId;
    private Integer integralPart;
    private UnsignedInt realPart;

    public ParameterReportMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        return ByteBuffer.allocate(header.length + dataSize).
                put(header).put(parameterId.byteValue()).putInt(integralPart).putInt(realPart.intValue());
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        parameterId = new UnsignedByte(buffer.get());
        integralPart = buffer.getInt();
        realPart = new UnsignedInt(buffer.getInt());
    }

    public UnsignedByte getParameterId() {
        return parameterId;
    }

    public void setParameterId(UnsignedByte parameterId) {
        this.parameterId = parameterId;
    }

    public Integer getIntegralPart() {
        return integralPart;
    }

    public void setIntegralPart(Integer integralPart) {
        this.integralPart = integralPart;
    }

    public UnsignedInt getRealPart() {
        return realPart;
    }

    public void setRealPart(UnsignedInt realPart) {
        this.realPart = realPart;
    }
}
