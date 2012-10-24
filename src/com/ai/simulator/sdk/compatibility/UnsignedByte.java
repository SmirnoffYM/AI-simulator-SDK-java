package com.ai.simulator.sdk.compatibility;

/**
 * Class represents unsigned byte variables.
 *
 * @author Smirnoff Y
 * @since 10/23/12 2:21 PM
 */
public final class UnsignedByte {

    private int value;

    public UnsignedByte(int value) {
        if (value < 0 || value > 255)
            throw new TypeCastException(value, UnsignedByte.class);
        this.value = value;
    }

    public UnsignedByte(byte value) {
        this.value = value + (value < 0 ? 256 : 0);
    }

    public int intValue() {
        return value;
    }

    public byte byteValue() {
        return (byte) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnsignedByte that = (UnsignedByte) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
