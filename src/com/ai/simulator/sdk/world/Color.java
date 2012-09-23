package com.ai.simulator.sdk.world;

/**
 * Class represents simple RGB color
 *
 * @author Smirnoff Y
 * @since 9/23/12 12:32 PM
 */
public class Color {

    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public Color(String color) {
        color = color.toLowerCase();
        if (!color.startsWith("#") || color.length() != 7)
            throw new RuntimeException("Invalid color string");
        red = Integer.valueOf(color.substring(1, 3), 16);
        green = Integer.valueOf(color.substring(3, 5), 16);
        blue = Integer.valueOf(color.substring(5, 7), 16);
    }

    public int red() {
        return red;
    }

    public int green() {
        return green;
    }

    public int blue() {
        return blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Color color = (Color) o;

        return blue == color.blue && green == color.green && red == color.red;
    }

    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }

    @Override
    public String toString() {
        return "#" + Integer.toString(red, 16) + Integer.toString(green, 16) + Integer.toString(blue, 16);
    }
}
