package org.example;

import jakarta.persistence.Embeddable;

@Embeddable
public class Color {

    private int red;
    private int green;
    private int blue;
    private int alpha;



    public Color() {}

    public Color(int red, int green, int blue, int alpha) {
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.alpha = alpha;
    }

    public Color(int red, int green, int blue){
        this(red,green,blue,0);

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

    public int alpha() {
        return alpha;
    }

    @Override
    public String toString() {
        return "Color{" +
                "red=" + red +
                ", green=" + green +
                ", blue=" + blue +
                ", alpha=" + alpha +
                '}';
    }
}