package ru.muzafarov.geometry;

import java.util.Objects;

/**
 * Класс, представляющий круг.
 */
public class Circle extends Shape {
    private Point center;
    private double radius;

    /**
     * Создает круг с указанным центром и радиусом.
     *
     * @param center Центр круга.
     * @param radius Радиус круга.
     * @throws IllegalArgumentException Если радиус отрицательный.
     */
    public Circle(Point center, double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.center = center;
        this.radius = radius;
    }

    /**
     * Создает круг с указанными координатами центра и радиусом.
     *
     * @param centerX Координата X центра круга.
     * @param centerY Координата Y центра круга.
     * @param radius  Радиус круга.
     * @throws IllegalArgumentException Если радиус отрицательный.
     */
    public Circle(double centerX, double centerY, double radius) {
        this(new Point(centerX, centerY), radius);
    }

    /**
     * Возвращает центр круга.
     *
     * @return Центр круга.
     */
    public Point getCenter() {
        return center;
    }

    /**
     * Устанавливает центр круга.
     *
     * @param center Новый центр круга.
     */
    public void setCenter(Point center) {
        this.center = center;
    }

    /**
     * Возвращает радиус круга.
     *
     * @return Радиус круга.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Устанавливает радиус круга.
     *
     * @param radius Новый радиус круга.
     * @throws IllegalArgumentException Если радиус отрицательный.
     */
    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным");
        }
        this.radius = radius;
    }

    /**
     * Вычисляет площадь круга.
     *
     * @return Площадь круга.
     */
    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    /**
     * Вычисляет длину окружности.
     *
     * @return Длина окружности.
     */
    public double circumference() {
        return 2 * Math.PI * radius;
    }

    /**
     * Возвращает строковое представление круга.
     *
     * @return Строковое представление круга.
     */
    @Override
    public String toString() {
        return "Круг: центр=" + center + ", радиус=" + radius;
    }

    /**
     * Сравнивает этот круг с другим объектом.
     *
     * @param obj Объект для сравнения.
     * @return true, если объекты равны, иначе false.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Circle circle = (Circle) obj;
        return Double.compare(circle.radius, radius) == 0 &&
                center.equals(circle.center);
    }

    /**
     * Возвращает хэш-код круга.
     *
     * @return Хэш-код круга.
     */
    @Override
    public int hashCode() {
        return Objects.hash(center, radius);
    }
}