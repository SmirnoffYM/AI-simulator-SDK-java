package com.ai.simulator.sdk.compatibility;

/**
 * Class represents unsigned short variables.
 *
 * @author Smirnoff Y
 * @since 10/23/12 9:17 PM
 */
public final class UnsignedShort {

    private int value;

    public UnsignedShort(int value) {
        if (value < 0 || value > 65535)
            throw new TypeCastException(value, UnsignedShort.class);
        this.value = value;
    }

    public UnsignedShort(short value) {
        this.value = value + (value < 0 ? 65536 : 0);
    }

    public int intValue() {
        return value;
    }

    public short shortValue() {
        return (short) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnsignedShort that = (UnsignedShort) o;

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

    public byte byteValue() {
        return (byte) value;
    }
}
