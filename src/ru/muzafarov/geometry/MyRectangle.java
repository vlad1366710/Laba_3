package ru.muzafarov.geometry;

/**
 * Класс, представляющий прямоугольник.
 */
public class MyRectangle extends Shape {
    private double topLeftX;
    private double topLeftY;
    private double width;
    private double height;

    /**
     * Создает прямоугольник по координатам верхнего левого угла, ширине и высоте.
     *
     * @param topLeftX Координата X верхнего левого угла.
     * @param topLeftY Координата Y верхнего левого угла.
     * @param width    Ширина прямоугольника.
     * @param height   Высота прямоугольника.
     * @throws IllegalArgumentException Если ширина или высота отрицательные.
     */
    public MyRectangle(double topLeftX, double topLeftY, double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Ширина и высота должны быть положительными числами.");
        }
        this.topLeftX = topLeftX;
        this.topLeftY = topLeftY;
        this.width = width;
        this.height = height;
    }

    /**
     * Возвращает площадь прямоугольника.
     *
     * @return Площадь прямоугольника.
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Возвращает строковое представление прямоугольника.
     *
     * @return Строковое представление прямоугольника.
     */
    @Override
    public String toString() {
        return "Прямоугольник: верхний левый угол=(" + topLeftX + ", " + topLeftY + "), ширина=" + width + ", высота=" + height;
    }
}