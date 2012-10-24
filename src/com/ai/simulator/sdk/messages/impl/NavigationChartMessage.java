package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.compatibility.UnsignedShort;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;

import java.nio.ByteBuffer;

/**
 * Navigation chart message (type = 9)
 *
 * @author Smirnoff Y
 * @see SimulatorMessage
 * @see Message
 * @since 10/18/12 11:39 AM
 */
@SimulatorMessage(type = 9)
public final class NavigationChartMessage extends Message {

    private UnsignedShort fragmentId;
    private int x;
    private int y;
    private UnsignedByte width;
    private UnsignedByte height;
    private UnsignedByte[][] pointHeights;

    public NavigationChartMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        int dataSize = 12 + pointHeights.length * pointHeights[0].length;
        ByteBuffer buffer = ByteBuffer.allocate(header.length + dataSize).put(header).putShort(fragmentId.shortValue()).
                putInt(x).putInt(y).put(width.byteValue()).put(height.byteValue());
        for (int i = 0; i < width.intValue(); i++)
            for (int j = 0; j < height.intValue(); j++)
                buffer.put(pointHeights[i][j].byteValue());
        return buffer;
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        fragmentId = new UnsignedShort(buffer.getShort());
        x = buffer.getInt();
        y = buffer.getInt();
        width = new UnsignedByte(buffer.get());
        height = new UnsignedByte(buffer.get());
        pointHeights = new UnsignedByte[width.intValue()][height.intValue()];
        for (int i = 0; i < width.intValue(); i++)
            for (int j = 0; j < height.intValue(); j++)
                pointHeights[i][j] = new UnsignedByte(buffer.get());
    }

    public UnsignedShort getFragmentId() {
        return fragmentId;
    }

    public void setFragmentId(UnsignedShort fragmentId) {
        this.fragmentId = fragmentId;
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

    public UnsignedByte getWidth() {
        return width;
    }

    public void setWidth(UnsignedByte width) {
        this.width = width;
    }

    public UnsignedByte getHeight() {
        return height;
    }

    public void setHeight(UnsignedByte height) {
        this.height = height;
    }

    public UnsignedByte[][] getPointHeights() {
        return pointHeights;
    }

    public void setPointHeights(UnsignedByte[][] pointHeights) {
        this.pointHeights = pointHeights;
    }
}
