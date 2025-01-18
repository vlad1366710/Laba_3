package ru.muzafarov.geometry;


public class Circle extends Shape {
    private double centerX;
    private double centerY;
    private double radius;

    public Circle(double centerX, double centerY, double radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return "Круг: центр=(" + centerX + ", " + centerY + "), радиус=" + radius;
    }
}