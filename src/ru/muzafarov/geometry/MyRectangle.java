package ru.muzafarov.geometry;

public class MyRectangle extends Shape {
    private double topLeftX;
    private double topLeftY;
    private double width;
    private double height;

    public MyRectangle(double topLeftX, double topLeftY, double width, double height) {
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public String toString() {
        return "прямоугольник: вверхняя левая точка=(" + topLeftX + ", " + topLeftY + "), длина=" + width + ", высота=" + height;
    }
}
