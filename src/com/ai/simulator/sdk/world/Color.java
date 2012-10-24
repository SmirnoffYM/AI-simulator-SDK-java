package com.ai.simulator.sdk.world;

import com.ai.simulator.sdk.compatibility.UnsignedByte;

/**
 * Class represents simple RGB color
 *
 * @author Smirnoff Y
 * @since 9/23/12 12:32 PM
 */
public final class Color {

    private UnsignedByte red;
    private UnsignedByte green;
    private UnsignedByte blue;

    public Color(int red, int green, int blue) {
        this.red = new UnsignedByte(red);
        this.green = new UnsignedByte(green);
        this.blue = new UnsignedByte(blue);
    }

    public Color(byte red, byte green, byte blue) {
        this.red = new UnsignedByte(red);
        this.green = new UnsignedByte(green);
        this.blue = new UnsignedByte(blue);
    }

    public Color(String color) {
        java.awt.Color col = java.awt.Color.decode(color);
        red = new UnsignedByte(col.getRed());
        green = new UnsignedByte(col.getGreen());
        blue = new UnsignedByte(col.getBlue());
    }

    public UnsignedByte red() {
        return red;
    }

    public UnsignedByte green() {
        return green;
    }

    public UnsignedByte blue() {
        return blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        return !(blue != null ? !blue.equals(color.blue) : color.blue != null)
                && !(green != null ? !green.equals(color.green) : color.green != null)
                && !(red != null ? !red.equals(color.red) : color.red != null);
    }

    @Override
    public int hashCode() {
        int result = red != null ? red.hashCode() : 0;
        result = 31 * result + (green != null ? green.hashCode() : 0);
        result = 31 * result + (blue != null ? blue.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "#" + Integer.toHexString(
                new java.awt.Color(red.intValue(), green.intValue(), blue.intValue()).getRGB()).substring(2);
    }
}
