package com.ai.simulator.sdk.messages.impl;

import com.ai.simulator.sdk.compatibility.UnsignedByte;
import com.ai.simulator.sdk.compatibility.UnsignedInt;
import com.ai.simulator.sdk.compatibility.UnsignedShort;
import com.ai.simulator.sdk.messages.Message;
import com.ai.simulator.sdk.messages.SimulatorMessage;
import com.ai.simulator.sdk.world.Color;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/**
 * There you see message class (type = 8)
 *
 * @author Smirnoff Y
 * @see Message
 * @see SimulatorMessage
 * @since 10/17/12 11:05 AM
 */
@SimulatorMessage(type = 8)
public final class ThereYouSeeMessage extends Message {

    private UnsignedShort mapPiecesNumber;
    private List<Object> objects;

    public ThereYouSeeMessage(int sequentialNumber, int envObjectID, int port) {
        super(sequentialNumber, envObjectID, port);
    }

    @Override
    protected ByteBuffer pack(byte[] header) {
        int dataSize = 6;
        for (Object object : objects) {
            if (object instanceof AgentObject) {
                dataSize += 18;
            } else if (object != null) {
                dataSize += 9;
            }
        }
        ByteBuffer buffer = ByteBuffer.allocate(header.length + dataSize);
        buffer = buffer.put(header).putShort(mapPiecesNumber.shortValue()).putInt(objects.size());
        for (Object object : objects) {
            if (object != null) {
                buffer = buffer.put(object.type.byteValue()).putInt(object.x).putInt(object.y);
                if (object instanceof AgentObject) {
                    AgentObject agentObject = (AgentObject) object;
                    buffer = buffer.putInt(agentObject.diameter.intValue()).
                            putShort(agentObject.orientation.shortValue()).
                            put(agentObject.color.red().byteValue()).
                            put(agentObject.color.green().byteValue()).
                            put(agentObject.color.blue().byteValue());
                }
            }
        }
        return buffer;
    }

    @Override
    protected void unpack(ByteBuffer buffer) {
        mapPiecesNumber = new UnsignedShort(buffer.getShort());
        UnsignedInt objectsQuantity = new UnsignedInt(buffer.getInt());
        objects = new ArrayList<>();
        for (long i = 0; i < objectsQuantity.longValue(); i++) {
            UnsignedByte type = new UnsignedByte(buffer.get());
            int x = buffer.getInt();
            int y = buffer.getInt();
            Object object;
            switch (type.intValue()) {
                case 0:
                    object = new Object(type.intValue(), x, y);
                    break;
                case 1:
                    int diameter = buffer.getInt();
                    short orientation = buffer.getShort();
                    Color color = new Color(buffer.get(), buffer.get(), buffer.get());
                    object = new AgentObject(x, y, diameter, orientation, color);
                    break;
                default:
                    throw new RuntimeException(
                            "Application received message 'There you see' with invalid object type " + type);
            }
            objects.add(object);
        }
    }

    public UnsignedShort getMapPiecesNumber() {
        return mapPiecesNumber;
    }

    public void setMapPiecesNumber(UnsignedShort mapPiecesNumber) {
        this.mapPiecesNumber = mapPiecesNumber;
    }

    public List<Object> getObjects() {
        return objects;
    }

    public void setObjects(List<Object> objects) {
        this.objects = objects;
    }

    public static class Object {

        private UnsignedByte type;
        private int x;
        private int y;

        public Object(int type, int x, int y) {
            this.type = new UnsignedByte(type);
            this.x = x;
            this.y = y;
        }

        public UnsignedByte getType() {
            return type;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static class AgentObject extends Object {

        private UnsignedInt diameter;
        private UnsignedShort orientation;
        private Color color;

        public AgentObject(int x, int y, int diameter, short orientation, Color color) {
            super(1, x, y);
            this.diameter = new UnsignedInt(diameter);
            this.orientation = new UnsignedShort(orientation);
            this.color = color;
        }

        public UnsignedInt getDiameter() {
            return diameter;
        }

        public UnsignedShort getOrientation() {
            return orientation;
        }

        public Color getColor() {
            return color;
        }
    }
}
