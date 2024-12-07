package org.example;

import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Use SINGLE_TABLE, JOINED, or TABLE_PER_CLASS as needed
@DiscriminatorColumn(name = "shape_type", discriminatorType = DiscriminatorType.STRING)
public abstract class Shape {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Embedded
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public Shape() {}

    public int getId() {
        return id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    abstract double getArea();

    abstract double getPerimeter();

    public String getColorDescription() {
        return String.format("Red: %d, Green: %d, Blue: %d, Alpha: %d",
                color.red(), color.green(), color.blue(), color.alpha());
    }

    @Override
    public String toString() {
        return "Shape{" +
                "id=" + id +
                ", color=" + getColorDescription() +
                '}';
    }
}