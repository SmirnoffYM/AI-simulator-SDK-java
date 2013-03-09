package com.ai.simulator.sdk.compatibility;

/**
 * Class represents unsigned integer variables.
 *
 * @author Smirnoff Y
 * @since 10/23/12 9:05 PM
 */
public final class UnsignedInt {

    private long value;

    public UnsignedInt(long value) {
        if (value < 0 || value > 4294967295l)
            throw new TypeCastException(value, UnsignedInt.class);
        this.value = value;
    }

    public UnsignedInt(int value) {
        this.value = value + (value < 0 ? 4294967296l : 0);
    }

    public long longValue() {
        return value;
    }

    public int intValue() {
        return (int) value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UnsignedInt that = (UnsignedInt) o;

        return value == that.value;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
