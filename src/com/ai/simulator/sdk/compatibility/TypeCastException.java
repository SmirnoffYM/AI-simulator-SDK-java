package com.ai.simulator.sdk.compatibility;

/**
 * Exception throwing when UnsignedInt, UnsignedShort or UnsignedByte object cannot be created from some value
 *
 * @author Smirnoff Y
 * @see RuntimeException
 * @since 10/23/12 8:23 PM
 */
@SuppressWarnings("unused")
public class TypeCastException extends RuntimeException {

    private Object value;
    private Class type;

    public TypeCastException(Object value, Class type) {
        super("Cannot cast " + value + " to type " + type.getName());
        this.value = value;
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public Class getType() {
        return type;
    }
}
